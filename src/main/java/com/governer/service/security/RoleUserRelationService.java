package com.governer.service.security;

import com.governer.domain.po.RoleUserRelationPO;

public interface RoleUserRelationService {

	void insertNotNull(RoleUserRelationPO relation);

	void delete(RoleUserRelationPO relation);

}
