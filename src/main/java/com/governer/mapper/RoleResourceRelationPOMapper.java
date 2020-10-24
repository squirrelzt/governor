package com.governer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RoleResourceRelationPOMapper {

	void deleteByFields(Object parameters);

	void insertSelective(Object parameters);

}
