package com.governer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RoleUserRelationPOMapper {

	void insertSelective(Object parameters);
	
	void deleteByFields(Object parameters);

}
