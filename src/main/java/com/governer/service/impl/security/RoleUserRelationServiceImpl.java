package com.governer.service.impl.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.governer.domain.po.RoleUserRelationPO;
import com.governer.mapper.RoleUserRelationPOMapper;
import com.governer.service.security.RoleUserRelationService;

@Service
public class RoleUserRelationServiceImpl implements RoleUserRelationService {
	
	@Autowired
	RoleUserRelationPOMapper roleUserRelationPOMapper;

	@Override
	public void insertNotNull(RoleUserRelationPO relation) {
		roleUserRelationPOMapper.insertSelective(relation);
	}

	@Override
	public void delete(RoleUserRelationPO relation) {
		roleUserRelationPOMapper.deleteByFields(relation);
	}

}
