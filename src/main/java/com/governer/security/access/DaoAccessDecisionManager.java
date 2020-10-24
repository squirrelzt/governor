package com.governer.security.access;

import java.util.Collection;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

/**
 * 权限决策器
 * 
 * @author xp.zhao
 *
 */
@Component
public class DaoAccessDecisionManager implements AccessDecisionManager {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {

		FilterInvocation fi = (FilterInvocation) object;
		
		Iterator<ConfigAttribute> ite = configAttributes.iterator();
		while (ite.hasNext()) {
			ConfigAttribute ca = ite.next();
			String needRole = ca.getAttribute();
			
			for (GrantedAuthority ga : authentication.getAuthorities()) {
				if(needRole.equals(ga.getAuthority())) {
					return;
				}
			}
		}
		
		// URL 有配置权限，但是登录用户没有匹配到对应权限，则禁止访问
		logger.error(HttpStatus.FORBIDDEN + fi.getRequestUrl());
		throw new AccessDeniedException(HttpStatus.FORBIDDEN.toString());
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}
}