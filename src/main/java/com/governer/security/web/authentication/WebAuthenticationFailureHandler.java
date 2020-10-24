package com.governer.security.web.authentication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.governer.security.core.userdetails.WebAuthenticationService;
import com.governer.security.properties.WebProperties;

/**
 * 认证失败处理类
 * <p>前后端分离，返回 JSON 结构</p>
 * 
 * @author xp.zhao
 *
 */
@Component
public class WebAuthenticationFailureHandler implements AuthenticationFailureHandler {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WebAuthenticationService webAuthenticationService;
	
	@Autowired
	private WebProperties webProperties;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		logger.error(exception.getLocalizedMessage());
		
		String username = (String) request.getAttribute(webProperties.getUsernameParameter());
		String responseContent = webAuthenticationService.onAuthenticationFailure(username, exception);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(responseContent);
		out.flush();
		out.close();
	}
}
