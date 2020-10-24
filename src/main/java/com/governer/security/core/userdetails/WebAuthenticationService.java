package com.governer.security.core.userdetails;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 
 * 
 * @author xp.zhao
 *
 */
public interface WebAuthenticationService {

	/**
	 * Locates the user based on the username. In the actual implementation, the search
	 * may possibly be case sensitive, or case insensitive depending on how the
	 * implementation instance is configured. In this case, the <code>UserDetails</code>
	 * object that comes back may have a username that is of a different case than what
	 * was actually requested..
	 *
	 * @param username the username identifying the user whose data is required.
	 *
	 * @return a fully populated user record (never <code>null</code>)
	 *
	 * @throws UsernameNotFoundException if the user could not be found or the user has no
	 * GrantedAuthority
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	
	/**
	 * 登陆成功时处理方法
	 * 
	 * @param authentication 认证信息
	 * @return JSON 结构的响应内容：{"code": "401", "data": "#登录用户信息#", "message": "Login success!"}
	 */
	public String onAuthenticationSuccess(Authentication authentication);
	
	/**
	 * 登录失败时处理方法
	 * 
	 * @param username 用户名
	 * @param exception 异常信息
	 * @return JSON 结构的响应内容：{"code": "401", "message": "Username not found!"}
	 */
	public String onAuthenticationFailure(String username, AuthenticationException exception);
	
	/**
	 * 根据token获取用户名
	 * 
	 * @param authentication 认证信息
	 * @return
	 */
	public String getUsernameByToken(String token);
	
	/**
	 * 登出成功时处理方法
	 * 
	 * @param request
	 * @param response
	 * @param authentication
	 * @return JSON 结构的响应内容：{"code": "200", "message": "User logout success!"}
	 */
	public String onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication);
}
