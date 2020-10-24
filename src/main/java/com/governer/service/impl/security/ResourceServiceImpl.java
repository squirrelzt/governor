package com.governer.service.impl.security;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.governer.common.PageParam;
import com.governer.domain.po.ResourcePO;
import com.governer.mapper.ResourcePOMapper;
import com.governer.mapper.RoleResourceRelationPOMapper;
import com.governer.security.util.CodeUtil;
import com.governer.service.security.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private ResourcePOMapper resourcePOMapper;

	@Autowired
	private RoleResourceRelationPOMapper roleResourceRelationPOMapper;

	@Override
	public String insertResource(Map<String, Object> params) {
		ResourcePO resource = JSON.parseObject(JSON.toJSONString(params), ResourcePO.class);

		// 校验唯一性
		ResourcePO tmp = new ResourcePO();
		tmp.setResourceCode(resource.getResourceCode());
		if (!isUnique(tmp))
			return CodeUtil.ERROR_RESOU_EXIST;

		// 设置资源路径
		tmp.setResourceCode(resource.getResourceParent());
		ResourcePO parent = this.selectOne(tmp);
		resource.setResourcePath((null != parent ? parent.getResourcePath() : "") + "." + resource.getResourceParent());

		resourcePOMapper.insertSelective(resource);
		return CodeUtil.INFO_200;
	}

	@Override
	public void deleteResource(ResourcePO resource) {
		Map<String, Object> param = new HashMap<>();
		param.put("resourceCode", resource.getResourceCode());

		// 删除资源与角色关系
		roleResourceRelationPOMapper.deleteByFields(param);

		this.delete(param);
	}

	@Override
	public List<ResourcePO> selectList(Object parameters) {
		return resourcePOMapper.selectByFields(parameters);
	}

	@Override
	public List<Object> selectByRole(Object params) {
		return resourcePOMapper.selectByRole(params);
	}

	@Override
	public List<Object> selectChilds(ResourcePO tmp) {
		return resourcePOMapper.selectChilds(tmp);
	}

	@Override
	public void delete(Object parameters) {
		resourcePOMapper.deleteByFields(parameters);
	}

	@Override
	public void updateNotNull(ResourcePO resource) {
		resourcePOMapper.updateByPrimaryKeySelective(resource);
	}

	@Override
	public PageInfo<ResourcePO> pageQuery(Object params, PageParam pageParam) {
		PageHelper.startPage(pageParam);
		List<ResourcePO> list = resourcePOMapper.selectByFields(params);
		PageInfo<ResourcePO> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public ResourcePO selectOne(ResourcePO parseObject) {
		List<ResourcePO> list = resourcePOMapper.selectByFields(parseObject);
		return CollectionUtils.isEmpty(list) ? null : list.get(0);
	}

	@Override
	public List<ResourcePO> selectRouters(Object parameters) {
		return resourcePOMapper.selectRouters(parameters);
	}

	@Override
	public boolean isUnique(ResourcePO parameters) {
		List<ResourcePO> list = resourcePOMapper.selectByFields(parameters);
		return CollectionUtils.isEmpty(list);
	}

}
