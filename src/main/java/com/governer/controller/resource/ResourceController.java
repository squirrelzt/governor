package com.governer.controller.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.governer.common.BaseResponse;
import com.governer.common.PageParam;
import com.governer.domain.po.ResourcePO;
import com.governer.enums.ResponseCodeEnums;
import com.governer.security.properties.WebProperties;
import com.governer.security.util.CodeUtil;
import com.governer.security.util.Constants;
import com.governer.security.util.JWTUtils;
import com.governer.service.security.ResourceService;
import com.governer.service.security.ResourceType;

import io.swagger.annotations.ApiOperation;

@RequestMapping("/resource")
@RestController
public class ResourceController {
	
	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	private WebProperties webPropertied;
	
	@GetMapping
    @ApiOperation(value = "查询（单条）")
	public BaseResponse<Object> getResource(@RequestParam Map<String, String> params) {
		ResourcePO result = resourceService.selectOne(JSON.parseObject(JSON.toJSONString(params), ResourcePO.class));
		return BaseResponse.ok(result);
	}
	
	@GetMapping("page")
    @ApiOperation(value = "查询（分页）")
	public BaseResponse<Object> getResourceWithPage(@RequestParam Map<String, String> params) {
		PageParam pageParam = JSON.parseObject(JSON.toJSONString(params), PageParam.class);
		
		if(!StringUtils.isEmpty(params.get("resourceCode")))
			params.put("resourceCode", "%" + params.get("resourceCode") + "%");
		if(!StringUtils.isEmpty(params.get("resourceName")))
			params.put("resourceName", "%" + params.get("resourceName") + "%");
		
		PageInfo<ResourcePO> result = resourceService.pageQuery(params, pageParam);

		BaseResponse<Object> br = new BaseResponse<>();
		br.setCode(ResponseCodeEnums.SUCCESS.getCode());
		br.setData(result.getList());
		br.setPageNumber(result.getPageNum());
		br.setPageSize(result.getPageSize());
		br.setTotal(result.getTotal());
		return br;
	}
	
	@GetMapping("/resources")
    @ApiOperation(value = "查询（集合）")
	public BaseResponse<Object> getResources(@RequestParam Map<String, Object> resource) {
		List<ResourcePO> result = resourceService.selectList(resource);
		return BaseResponse.ok(result);
	}
	
	@PostMapping
    @ApiOperation(value = "新增")
	public BaseResponse<Object> insert(@RequestBody Map<String, Object> resource) {
		String result = resourceService.insertResource(resource);
		if(CodeUtil.INFO_200.equals(result)) {
			return BaseResponse.ok(CodeUtil.INFO_200);
		} else {
			return BaseResponse.fail(result);
		}
	}

	@PutMapping
    @ApiOperation(value = "更新")
	public BaseResponse<Object> update(@RequestBody ResourcePO resource) {
		resourceService.updateNotNull(resource);
		return BaseResponse.ok(null);
	}
	
	@DeleteMapping
    @ApiOperation(value = "删除")
	public BaseResponse<Object> delete(@RequestBody ResourcePO resource) {
		resourceService.deleteResource(resource);
		return BaseResponse.ok(null);
	}
	
	@DeleteMapping("/resources")
    @ApiOperation(value = "删除（批量）")
	public BaseResponse<Object> deleteBatch(@RequestBody Map<String, Object> params) {
		List<ResourcePO> list = JSON.parseArray(params.get("selectedData").toString(), ResourcePO.class);
		for (ResourcePO resource : list) {
			resourceService.delete(resource);
		}
		return BaseResponse.ok(null);
	}
	
	@GetMapping("/sub")
    @ApiOperation(value = "查询")
	public BaseResponse<Object> getResourceTree(@RequestParam Map<String, String> params) {
		ResourcePO tmp = new ResourcePO();
		
		if(StringUtils.isEmpty(params.get("resourceParent")))
			tmp.setResourceParent(Constants.DEFAULT_MENU_ROOT);
		else
			tmp.setResourceParent(params.get("resourceCode"));
		
		tmp.setResourceType(params.get("type"));
		
		List<Object> result = resourceService.selectChilds(tmp);
		return BaseResponse.ok(result);
	}
	
	@GetMapping("/authority")
    @ApiOperation(value = "获取元素权限")
	public BaseResponse<Object> getResourceAuthority(@RequestParam Map<String, String> params) {
		// 元素-按钮
		params.put("resourceType", "btn");
		List<ResourcePO> result1 = resourceService.selectList(params);
		// 元素-其他
		params.put("resourceType", "unit");
		List<ResourcePO> result2 = resourceService.selectList(params);
		
		// 合并
		result1.addAll(result2);
		
		return BaseResponse.ok(result1);
	}
	
	@GetMapping(value = "/routers")
    @ApiOperation(value = "获取路由数据")
	public BaseResponse<Object> buildRouters(HttpServletRequest request) {
		// 获取请求 token
		String token = request.getHeader(webPropertied.getAuthorize().getTokenName());
		String userCode = JWTUtils.unsign(token, String.class);
		
		Map<String, Object> params = new HashMap<>();
		params.put("userCode", userCode);
		
		// 菜单 + 路由
		List<String> resourceTypes = new ArrayList<>();
		resourceTypes.add(ResourceType.VIEW.getType());
		resourceTypes.add(ResourceType.URL.getType());
		params.put("resourceTypes", resourceTypes);
		
		List<ResourcePO> resourceList = resourceService.selectRouters(params);
		
		List<JSONObject> result = new ArrayList<>();
		for(ResourcePO tmp : resourceList) {
			JSONObject obj = JSON.parseObject(JSON.toJSONString(tmp));
			obj.put("isMenu", tmp.getResourceType().equals(ResourceType.VIEW.getType()));
			
			if(!StringUtils.isEmpty(tmp.getResourcePath()) && tmp.getResourcePath().endsWith(tmp.getResourceCode())) 
				obj.put("leaf", true);
			else
				obj.put("leaf", false);
			
			result.add(obj);
		}
		
		return BaseResponse.ok(result);
	}
}
