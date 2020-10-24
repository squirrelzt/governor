package com.governer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.governer.domain.po.DictPO;

@Mapper
@Repository
public interface DictPOMapper {

	List<DictPO> getDictItems(Object parameters);

	List<DictPO> selectByFields(Object parameters);

	List<DictPO> queryDictTypes(Object parameters);

	Integer insertSelective(Object parameters);
	
	Integer updateByPrimaryKey(Object parameters);
	
	Integer updateByPrimaryKeySelective(Object parameters);
	
	Integer deleteByFields(Object parameters);

}
