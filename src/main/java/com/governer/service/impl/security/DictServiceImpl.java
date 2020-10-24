package com.governer.service.impl.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.governer.common.PageParam;
import com.governer.domain.po.DictPO;
import com.governer.mapper.DictPOMapper;
import com.governer.service.security.DictService;

@Service
public class DictServiceImpl implements DictService {

	@Autowired
	private DictPOMapper dictPOMapper;

	@Override
	public DictPO selectOne(Object parameters) {
		List<DictPO> dicts = dictPOMapper.selectByFields(parameters);
		return CollectionUtils.isEmpty(dicts) ? null : dicts.get(0);
	}

	@Override
	public List<DictPO> getDictItems(Object params) {
		return dictPOMapper.getDictItems(params);
	}

	@Override
	public PageInfo<DictPO> queryDictTypes(Object parameters, PageParam pageParam) {
		PageHelper.startPage(pageParam);
		List<DictPO> list = dictPOMapper.queryDictTypes(parameters);
		PageInfo<DictPO> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public void insert(DictPO dict) {
		dictPOMapper.insertSelective(dict);
	}

	@Override
	public void update(DictPO dict) {
		dictPOMapper.updateByPrimaryKey(dict);
	}

	@Override
	public void updateNotNull(DictPO dict) {
		dictPOMapper.updateByPrimaryKeySelective(dict);
	}

	@Override
	public void delete(DictPO dict) {
		dictPOMapper.deleteByFields(dict);
	}

	@Override
	public void deleteDicts(List<DictPO> dicts, String corpCode) {
		for (DictPO dict : dicts) {
			dict.setCorpCode(corpCode);
			dictPOMapper.deleteByFields(dict);
		}
	}

}
