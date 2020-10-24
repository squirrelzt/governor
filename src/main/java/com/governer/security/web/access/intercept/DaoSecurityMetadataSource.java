package com.governer.security.web.access.intercept;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import com.governer.security.access.authority.WebAuthorityService;
import com.governer.security.properties.WebProperties;

/**
 * 资源源数据
 * 
 * @author xp.zhao
 *
 */
@Component
public class DaoSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	@Autowired
	private WebProperties webProperties;

	@Autowired
	private WebAuthorityService webAuthorityService;

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		FilterInvocation fi = (FilterInvocation) object;
		List<ConfigAttribute> apiAuthorities = webAuthorityService.loadApiAuthorities(fi.getRequest());
		
		// 精准权限模式
		boolean precise = webProperties.getAuthorize().getPrecise();
		if(precise && (apiAuthorities == null || apiAuthorities.isEmpty())) {
			apiAuthorities = SecurityConfig.createList("ROLE_PRECISE");
		}
		
		// 返回 null 时，不判断用户是否拥有 URL 的权限
		return apiAuthorities;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

}