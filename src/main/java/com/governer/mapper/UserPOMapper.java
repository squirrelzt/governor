package com.governer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.governer.domain.po.UserPO;

@Mapper
@Repository
public interface UserPOMapper {

	List<UserPO> selectByFields(Object params);

	void insertSelective(Object parameters);

	void updateByPrimaryKeySelective(Object parameters);

	void deleteByPrimaryKey(Integer id);

	List<UserPO> selectByRoleRelated(Object params);

	List<UserPO> selectByRoleUnRelated(Object params);

}
