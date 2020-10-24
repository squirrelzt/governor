package com.governer.service.impl.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.governer.common.PageParam;
import com.governer.domain.po.UserPO;
import com.governer.mapper.UserPOMapper;
import com.governer.service.security.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserPOMapper userPOMapper;

	@Override
	public UserPO selectOne(Object params) {
		List<UserPO> list = userPOMapper.selectByFields(params);
		return CollectionUtils.isEmpty(list) ? null : list.get(0);
	}

	@Override
	public PageInfo<UserPO> pageQuery(Object params, PageParam pageParam) {
		PageHelper.startPage(pageParam);
		List<UserPO> list = userPOMapper.selectByFields(params);
		PageInfo<UserPO> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public void insertNotNull(UserPO user) {
		userPOMapper.insertSelective(user);
	}

	@Override
	public void updateNotNull(UserPO user) {
		userPOMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public void deleteByPrimaryKey(Integer id) {
		userPOMapper.deleteByPrimaryKey(id);
	}

	@Override
	public PageInfo<UserPO> selectByRoleUnRelated(Object params, PageParam pageParam) {
		PageHelper.startPage(pageParam);
		List<UserPO> list = userPOMapper.selectByRoleUnRelated(params);
		PageInfo<UserPO> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public PageInfo<UserPO> selectByRoleRelated(Object params, PageParam pageParam) {
		PageHelper.startPage(pageParam);
		List<UserPO> list = userPOMapper.selectByRoleRelated(params);
		PageInfo<UserPO> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

}
