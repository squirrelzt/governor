package com.governer.security.web.authentication.logout;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.governer.security.core.userdetails.WebAuthenticationService;

/**
 * 登出成功处理类
 * 
 * @author xp.zhao
 *
 */
@Component
public class WebLogoutSuccessHandler implements LogoutSuccessHandler {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WebAuthenticationService webAuthenticationService;

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		logger.info("Logout Success!");
		
		String result = webAuthenticationService.onLogoutSuccess(request, response, authentication);

		response.setStatus(HttpServletResponse.SC_OK);
		response.setCharacterEncoding("UTF-8");
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		
		PrintWriter printWriter = response.getWriter();
		printWriter.write(result);
		printWriter.flush();
		printWriter.close();
	}

}
