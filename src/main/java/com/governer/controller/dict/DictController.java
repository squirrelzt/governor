package com.governer.controller.dict;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.governer.domain.po.DictPO;
import com.governer.enums.ResponseCodeEnums;
import com.governer.security.util.CodeUtil;
import com.governer.service.security.DictService;

import io.swagger.annotations.ApiOperation;

@RequestMapping("/dict")
@RestController
public class DictController {

	@Autowired
	private DictService dictService;

	@PostMapping("/common")
	@ApiOperation(value = "数据字典查询")
	public BaseResponse<Object> dicts(@RequestBody Map<String, Object> params) {
		List<String> param = JSON.parseArray(JSON.toJSONString(params.get("dictKey")), String.class);
		params.put("application", param.get(0));
		params.put("dictType", param.get(1));
		List<DictPO> result = dictService.getDictItems(params);
		return BaseResponse.ok(result);
	}

	@PostMapping("type")
	@ApiOperation(value = "新增数据字典类型")
	public BaseResponse<Object> addDictTitle(@RequestBody DictPO dict) {
		DictPO tmp = new DictPO();
		tmp.setApplication(dict.getApplication());
		tmp.setDictType("%");
		tmp.setDictCode(dict.getDictCode());
		tmp = dictService.selectOne(tmp);
		if (tmp != null) {
			return BaseResponse.fail(CodeUtil.ERROR_DICT_EXIST);
		}
		dict.setDictCode("%");
		dictService.insert(dict);
		return BaseResponse.ok(null);
	}

	@ApiOperation(value = "维护数据字典项")
	@PostMapping("/items/setting")
	public BaseResponse<Object> addDictItems(@RequestBody Map<String, String> params) {
		String appCode = params.get("application");
		String dictType = params.get("dictType");

		List<DictPO> addList = JSON.parseArray(params.get("addList"), DictPO.class);
		List<DictPO> updateList = JSON.parseArray(params.get("updateList"), DictPO.class);
		List<DictPO> deleteList = JSON.parseArray(params.get("deleteList"), DictPO.class);
		
		if(!CollectionUtils.isEmpty(addList)) {
			for (DictPO dict : addList) {
				dict.setApplication(appCode);
				dict.setDictType(dictType);
				dictService.insert(dict);
			}
		}

		if(!CollectionUtils.isEmpty(updateList)) {
			for (DictPO dict : updateList) {
				dict.setApplication(appCode);
				dict.setDictType(dictType);
				dictService.updateNotNull(dict);
			}
		}

		if(!CollectionUtils.isEmpty(deleteList)) {
			for (DictPO dict : deleteList) {
				dict.setApplication(appCode);
				dict.setDictType(dictType);
				dictService.delete(dict);
			}
		}

		return BaseResponse.ok(null);
	}

	@GetMapping("items")
	@ApiOperation(value = "获取数据字典项")
	public BaseResponse<Object> getDictItems(@RequestParam String dictType, @RequestParam String application) {
		DictPO tmp = new DictPO();
		tmp.setDictType(dictType);
		tmp.setApplication(application);
		
		List<DictPO> list = dictService.getDictItems(tmp);
		return BaseResponse.ok(list);
	}

	@PutMapping("/type")
	@ApiOperation(value = "修改数据字典")
	public BaseResponse<Object> updateDict(@RequestBody DictPO dict) {
		dictService.updateNotNull(dict);
		return BaseResponse.ok(null);
	}

	@GetMapping("/type/{id}")
	@ApiOperation(value = "根据 id 获取数据字典")
	public BaseResponse<Object> getDict(@PathVariable Integer id) {
		DictPO tmp = new DictPO();
		tmp.setId(id);
		
		DictPO dict = dictService.selectOne(tmp);
		return BaseResponse.ok(dict);
	}
	
	@GetMapping("/page")
	@ApiOperation(value = "查询数据字典类型（分页）")
	public BaseResponse<Object> queryDictTypes(@RequestParam Map<String, Object> param) {
		if (!StringUtils.isEmpty(param.get("dictType"))) {
			param.put("dictType", "%" + param.get("dictType") + "%");
		}
		if (!StringUtils.isEmpty(param.get("dictName"))) {
			param.put("dictName", "%" + param.get("dictName") + "%");
		}

		PageParam pageParam = JSON.parseObject(JSON.toJSONString(param), PageParam.class);
		pageParam.setSortName("sequence#");
		pageParam.setSortOrder("asc");

		PageInfo<DictPO> result = dictService.queryDictTypes(param, pageParam);
		
		BaseResponse<Object> br = new BaseResponse<>();
		br.setCode(ResponseCodeEnums.SUCCESS.getCode());
		br.setData(result.getList());
		br.setPageNumber(result.getPageNum());
		br.setPageSize(result.getPageSize());
		br.setTotal(result.getTotal());
		return br;
	}

	@DeleteMapping("/type/batch")
	@ApiOperation(value = "批量删除数据字典")
	public BaseResponse<Object> deleteDicts(@RequestBody Map<String, Object> params) {
		List<DictPO> dicts = JSON.parseArray(JSON.toJSONString(params.get("selectedData")), DictPO.class);
		dictService.deleteDicts(dicts, "");
		return BaseResponse.ok(null);
	}
}