package com.governer.service.impl.security;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.governer.common.PageParam;
import com.governer.domain.po.RolePO;
import com.governer.domain.po.RoleResourceRelationPO;
import com.governer.mapper.RolePOMapper;
import com.governer.mapper.RoleResourceRelationPOMapper;
import com.governer.service.security.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RolePOMapper rolePOMapper;
	
	@Autowired
	private RoleResourceRelationPOMapper roleResourceRelationPOMapper;

	@Override
	public List<RolePO> selectByResources(Object parameters) {
		return rolePOMapper.selectByResources(parameters);
	}

	/**
	 * 资源组关联资源
	 *
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void grantResources(Map<String, Object> params) {
		// 删除资源组与资源关系
		roleResourceRelationPOMapper.deleteByFields(params);

		List<String> resourceCodes = (List<String>) params.get("selectedTree");
		for(String resourceCode : resourceCodes) {
			RoleResourceRelationPO roleResourceRelation = new RoleResourceRelationPO();
			roleResourceRelation.setRoleCode(String.valueOf(params.get("roleCode")));
			roleResourceRelation.setResourceCode(resourceCode);
			roleResourceRelationPOMapper.insertSelective(roleResourceRelation);
		}
	}

	@Override
	public List<RolePO> selectByUser(Object parameters) {
		List<RolePO> list = rolePOMapper.selectByUser(parameters);
		return list;
	}

	@Override
	public List<RolePO> selectList(Object parameters) {
		return rolePOMapper.selectByFields(parameters);
	}

	@Override
	public PageInfo<RolePO> pageQuery(Object params, PageParam pageParam) {
		PageHelper.startPage(pageParam);
		List<RolePO> list = rolePOMapper.selectByFields(params);
		PageInfo<RolePO> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public RolePO selectOne(Object params) {
		List<RolePO> list = rolePOMapper.selectByFields(params);
		return CollectionUtils.isEmpty(list) ? null : list.get(0);
	}

	@Override
	public boolean isUnique(RolePO tmp) {
		List<RolePO> list = rolePOMapper.selectByFields(tmp);
		return CollectionUtils.isEmpty(list);
	}

	@Override
	public void insertNotNull(RolePO role) {
		rolePOMapper.insertSelective(role);
	}

	@Override
	public void updateNotNull(RolePO role) {
		rolePOMapper.updateByPrimaryKeySelective(role);
	}

	@Override
	public void delete(RolePO role) {
		rolePOMapper.deleteByFields(role);
	}

}
