package com.governer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.governer.domain.po.RolePO;

@Mapper
@Repository
public interface RolePOMapper {

	List<RolePO> selectByResources(Object parameters);

	List<RolePO> selectByUser(Object parameters);

	List<RolePO> selectByFields(Object params);

	void insertSelective(Object parameters);

	void updateByPrimaryKeySelective(Object parameters);

	void deleteByFields(Object parameters);
}
