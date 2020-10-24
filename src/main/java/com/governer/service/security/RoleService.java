package com.governer.service.security;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.governer.common.PageParam;
import com.governer.domain.po.RolePO;

public interface RoleService {

	public List<RolePO> selectList(Object parameters);
	
	public void grantResources(Map<String, Object> params);

	public List<RolePO> selectByResources(Object parameters);

	public List<RolePO> selectByUser(Object parameters);

	public PageInfo<RolePO> pageQuery(Object params, PageParam pageParam);

	public RolePO selectOne(Object params);

	public boolean isUnique(RolePO tmp);

	public void insertNotNull(RolePO role);

	public void updateNotNull(RolePO role);

	public void delete(RolePO role);
}
