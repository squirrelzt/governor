package com.governer.security.access.authority;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.ConfigAttribute;

/**
 * 权限接口类.
 * 
 * @author xp.zhao
 *
 */
public interface WebAuthorityService {
	
	/**
	 * 根据请求加载所需权限
	 * <p>可根据 requestUrl 和 method 加载请求权限</p>
	 * 
	 * @param request
	 * @return
	 */
	public List<ConfigAttribute> loadApiAuthorities(HttpServletRequest request);

	/**
	 * 获取数据规则的 SQL 子句，默认返回 null
	 * 
	 * @param privId 数据规则编码
	 * @param alias 表别名
	 * @return
	 */
	public String getFilterSql(String privId, String alias);
}
