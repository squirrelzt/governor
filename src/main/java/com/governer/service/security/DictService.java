package com.governer.service.security;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.governer.common.PageParam;
import com.governer.domain.po.DictPO;

public interface DictService {

	DictPO selectOne(Object parameters);

	List<DictPO> getDictItems(Object params);

	PageInfo<DictPO> queryDictTypes(Object param, PageParam pageParam);

	void insert(DictPO dict);

	void update(DictPO dict);

	void updateNotNull(DictPO dict);

	void delete(DictPO dict);

	void deleteDicts(List<DictPO> dicts, String string);

}
