package com.governer.security.web.authentication;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StringUtils;

import com.auth0.jwt.internal.com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <p>1、覆盖 obtainUsername 和 obtainPassword 方法，支持 JSON 数据模式获取用户名/密码</p>
 * 
 * @author xp.zhao
 *
 */
public class WebUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private ThreadLocal<Map<String, String>> threadLocal = new ThreadLocal<>();

	@Override
	protected String obtainUsername(HttpServletRequest request) {
		String username = this.getBodyParams(request).get(super.getUsernameParameter());
		username = StringUtils.isEmpty(username) ? super.obtainUsername(request) : username;
		
		// request.getInputStream() 只能使用一次，所以设置用户名用于登录失败时使用
		request.setAttribute(super.getUsernameParameter(), username);
		return username;
	}

	@Override
	protected String obtainPassword(HttpServletRequest request) {
		String password = this.getBodyParams(request).get(super.getPasswordParameter());
		return StringUtils.isEmpty(password) ? super.obtainPassword(request) : password;
	}

	@SuppressWarnings("unchecked")
	private Map<String, String> getBodyParams(HttpServletRequest request) {
		Map<String, String> bodyParams = threadLocal.get();

		if (bodyParams == null) {
			ObjectMapper objectMapper = new ObjectMapper();
			try (InputStream is = request.getInputStream()) {
				bodyParams = objectMapper.readValue(is, Map.class);
			} catch (IOException e) {
			}

			if (bodyParams == null)
				bodyParams = new HashMap<>();

			threadLocal.set(bodyParams);
		}

		return bodyParams;
	}
}
