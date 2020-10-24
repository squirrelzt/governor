package com.governer.security.web.authentication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.governer.security.core.userdetails.WebAuthenticationService;

/**
 * 认证成功处理类
 * <p>前后端分离，返回 JSON 结构</p>
 * 
 * @author xp.zhao
 *
 */
@Component
public class WebAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	@Autowired
	private WebAuthenticationService webAuthenticationService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		String responseContent = webAuthenticationService.onAuthenticationSuccess(authentication);

		// 设置响应头
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(responseContent);
		out.flush();
		out.close();
	}

}
