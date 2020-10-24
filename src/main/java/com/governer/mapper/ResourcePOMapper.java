package com.governer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.governer.domain.po.ResourcePO;

@Mapper
@Repository
public interface ResourcePOMapper {

	List<ResourcePO> selectByFields(Object parameters);

	List<ResourcePO> selectRouters(Object parameters);

	List<Object> selectChilds(Object parameters);

	Integer insertSelective(Object parameters);
	
	Integer updateByPrimaryKeySelective(Object parameters);
	
	Integer deleteByFields(Object parameters);

	List<Object> selectByRole(Object parameters);
}
