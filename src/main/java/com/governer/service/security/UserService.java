package com.governer.service.security;

import com.github.pagehelper.PageInfo;
import com.governer.common.PageParam;
import com.governer.domain.po.UserPO;

public interface UserService {

	UserPO selectOne(Object parameters);

	void updateNotNull(UserPO user);

	PageInfo<UserPO> pageQuery(Object params, PageParam pageParam);

	void deleteByPrimaryKey(Integer id);

	void insertNotNull(UserPO user);

	PageInfo<UserPO> selectByRoleUnRelated(Object params, PageParam pageParam);

	PageInfo<UserPO> selectByRoleRelated(Object params, PageParam pageParam);

}
