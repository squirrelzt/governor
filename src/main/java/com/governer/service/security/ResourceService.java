package com.governer.service.security;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.governer.common.PageParam;
import com.governer.domain.po.ResourcePO;

public interface ResourceService {

	public String insertResource(Map<String, Object> params);
	
	public void deleteResource(ResourcePO resource);
	
	public List<ResourcePO> selectList(Object parameters);

	public List<Object> selectByRole(Object params);

	public List<Object> selectChilds(ResourcePO tmp);

	public void delete(Object parameters);

	public void updateNotNull(ResourcePO resource);

	public PageInfo<ResourcePO> pageQuery(Object params, PageParam pageParam);

	public ResourcePO selectOne(ResourcePO parseObject);

	public List<ResourcePO> selectRouters(Object params);
	
	boolean isUnique(ResourcePO parameters);
}
