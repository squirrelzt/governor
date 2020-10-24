package com.governer.security.web.authentication.logout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

/**
 * 登出处理类
 * 
 * @author xp.zhao
 *
 */
public class WebLogoutHandler implements LogoutHandler {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		logger.info(request.getHeader("token"));
	}

}
