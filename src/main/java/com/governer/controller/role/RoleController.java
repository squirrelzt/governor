package com.governer.controller.role;

import java.util.List;
import java.util.Map;

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
import com.github.pagehelper.PageInfo;
import com.governer.common.BaseResponse;
import com.governer.common.PageParam;
import com.governer.domain.po.RolePO;
import com.governer.domain.po.RoleUserRelationPO;
import com.governer.domain.po.UserPO;
import com.governer.enums.ResponseCodeEnums;
import com.governer.security.util.CodeUtil;
import com.governer.service.security.ResourceService;
import com.governer.service.security.RoleService;
import com.governer.service.security.RoleUserRelationService;
import com.governer.service.security.UserService;

import io.swagger.annotations.ApiOperation;

@RequestMapping("/role")
@RestController
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	private RoleUserRelationService roleUserRelationService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("page")
    @ApiOperation(value = "查询")
	public BaseResponse<Object> queryPage(@RequestParam Map<String, String> params, PageParam pageParam) {
		if (!StringUtils.isEmpty(params.get("roleCode"))) {
			params.put("roleCode", "%" + params.get("roleCode") + "%");
		}
		if (!StringUtils.isEmpty(params.get("roleName"))) {
			params.put("roleName", "%" + params.get("roleName") + "%");
		}
		
		PageInfo<RolePO> result = roleService.pageQuery(params, pageParam);
		
		BaseResponse<Object> br = new BaseResponse<>();
		br.setCode(ResponseCodeEnums.SUCCESS.getCode());
		br.setData(result.getList());
		br.setPageNumber(result.getPageNum());
		br.setPageSize(result.getPageSize());
		br.setTotal(result.getTotal());
		return br;
	}
	
	@GetMapping
    @ApiOperation(value = "查询")
	public BaseResponse<Object> get(@RequestParam Map<String, Object> params) {
		RolePO p = JSON.parseObject(JSON.toJSONString(params), RolePO.class);
		RolePO result = roleService.selectOne(p);
		return BaseResponse.ok(result);
	}
	
	@GetMapping("/list")
    @ApiOperation(value = "查询")
	public BaseResponse<Object> queryList(@RequestParam Map<String, Object> role) {
		List<RolePO> result = roleService.selectList(role);
		return BaseResponse.ok(result);
	}
	
	@PostMapping
    @ApiOperation(value = "新增")
	public BaseResponse<Object> insert(@RequestBody RolePO role) {
		// 校验唯一性
		RolePO tmp = new RolePO();
		tmp.setRoleCode(role.getRoleCode());
		if (!roleService.isUnique(tmp))
			BaseResponse.fail(CodeUtil.ERROR_ROLE_EXIST);

		roleService.insertNotNull(role);
		return BaseResponse.ok(null);
	}

	@PutMapping
    @ApiOperation(value = "更新")
	public BaseResponse<Object> update(@RequestBody RolePO role) {
		roleService.updateNotNull(role);
		return BaseResponse.ok(null);
	}
	
	@DeleteMapping
    @ApiOperation(value = "删除")
	public BaseResponse<Object> delete(@RequestBody RolePO role) {
		roleService.delete(role);
		return BaseResponse.ok(null);
	}
	
	@DeleteMapping("/batch")
    @ApiOperation(value = "删除")
	public BaseResponse<Object> deleteBatch(@RequestBody Map<String, Object> params) {
		List<RolePO> list = JSON.parseArray(params.get("selectedData").toString(), RolePO.class);
		for (RolePO role : list) {
			roleService.delete(role);
		}
		return BaseResponse.ok(null);
	}
	
	@GetMapping("/resources")
    @ApiOperation(value = "加载资源（树形）")
	public BaseResponse<Object> getResourceWithTree(@RequestParam Map<String, String> params) {
		List<Object> result = resourceService.selectByRole(params);
		return BaseResponse.ok(result);
	}
	
	@PostMapping("/grant-resource")
    @ApiOperation(value = "关联资源")
	public BaseResponse<Object> grantResources(@RequestBody Map<String, Object> params) {
		roleService.grantResources(params);
		return BaseResponse.ok(null);
	}
	
	@GetMapping("/user/unrelated")
    @ApiOperation(value = "查询未关联用户")
	public BaseResponse<Object> queryUnRelation(@RequestParam Map<String, String> params) {
		PageParam pageParam = JSON.parseObject(JSON.toJSONString(params), PageParam.class);

		if(!StringUtils.isEmpty(params.get("userCode")))
			params.put("userCode", "%" + params.get("userCode") + "%");
		if(!StringUtils.isEmpty(params.get("userName")))
			params.put("userName", "%" + params.get("userName") + "%");
		
		PageInfo<UserPO> result = userService.selectByRoleUnRelated(params, pageParam);
		
		BaseResponse<Object> br = new BaseResponse<>();
		br.setCode(ResponseCodeEnums.SUCCESS.getCode());
		br.setData(result.getList());
		br.setPageNumber(result.getPageNum());
		br.setPageSize(result.getPageSize());
		br.setTotal(result.getTotal());
		return br;
	}
	
	@PostMapping("/user")
    @ApiOperation(value = "增加角色用户关联")
	public BaseResponse<Object> addRelation(@RequestBody Map<String, Object> params) {
		List<UserPO> list = JSON.parseArray(JSON.toJSONString(params.get("selectedList")), UserPO.class);
		for(UserPO user : list) {
			RoleUserRelationPO relation = new RoleUserRelationPO();
			relation.setRoleCode(String.valueOf(params.get("roleCode")));
			relation.setUserCode(user.getUserCode());
			roleUserRelationService.insertNotNull(relation);
		}
		return BaseResponse.ok(null);
	}

	@GetMapping("/user/related")
    @ApiOperation(value = "查询已授权资源组")
	public BaseResponse<Object> getPositionGranted(@RequestParam Map<String, String> params) {
		PageParam pageParam = JSON.parseObject(JSON.toJSONString(params), PageParam.class);

		if(!StringUtils.isEmpty(params.get("userCode")))
			params.put("userCode", "%" + params.get("userCode") + "%");
		if(!StringUtils.isEmpty(params.get("userName")))
			params.put("userName", "%" + params.get("userName") + "%");
		
		PageInfo<UserPO> result = userService.selectByRoleRelated(params, pageParam);
		
		BaseResponse<Object> br = new BaseResponse<>();
		br.setCode(ResponseCodeEnums.SUCCESS.getCode());
		br.setData(result.getList());
		br.setPageNumber(result.getPageNum());
		br.setPageSize(result.getPageSize());
		br.setTotal(result.getTotal());
		return br;
	}
	
	@DeleteMapping("/user")
    @ApiOperation(value = "取消角色用户关联")
	public BaseResponse<Object> removeRelation(@RequestBody Map<String, Object> params) {
		List<UserPO> list = JSON.parseArray(JSON.toJSONString(params.get("selectedList")), UserPO.class);
		for(UserPO user : list) {
			RoleUserRelationPO relation = new RoleUserRelationPO();
			relation.setRoleCode(String.valueOf(params.get("roleCode")));
			relation.setUserCode(user.getUserCode());
			roleUserRelationService.delete(relation);
		}
		return BaseResponse.ok(null);
	}
}
