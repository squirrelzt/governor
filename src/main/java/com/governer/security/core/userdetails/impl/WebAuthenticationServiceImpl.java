package com.governer.security.core.userdetails.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.governer.domain.po.RolePO;
import com.governer.domain.po.UserPO;
import com.governer.security.core.userdetails.WebAuthenticationService;
import com.governer.security.util.CodeUtil;
import com.governer.security.util.Constants;
import com.governer.security.util.JWTUtils;
import com.governer.service.security.RoleService;
import com.governer.service.security.UserService;

@Service
public class WebAuthenticationServiceImpl implements WebAuthenticationService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Value("${web.max-password-errors:5}")
	private int maxPasswordErrors;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Map<String, Object> params = new HashMap<>();
		params.put("userCode", username);
		UserPO user = userService.selectOne(params);
		
		if(null == user) 
			return null;
		
		Map<String, Object> role_params = new HashMap<>();
		role_params.put("userCode", user.getUserCode());
		List<RolePO> roles = roleService.selectByUser(role_params);
		
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for(RolePO role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getRoleCode()));
		}
		
		WebUserDetails webUserDetails = new WebUserDetails();
		webUserDetails.setUsername(username);
		webUserDetails.setName(user.getUserName());
		webUserDetails.setPassword(passwordEncoder.encode(user.getUserPassword()));
		webUserDetails.setLayout(user.getMenuType());
		webUserDetails.setTheme(user.getSkinCode());
		webUserDetails.setDashboard(user.getDefaultDashboard());
		
		webUserDetails.setOrgCode(user.getOrgCode());
		webUserDetails.setCorpCode(null);
		
		webUserDetails.setEnabled("1".equals(user.getEnable()));
		webUserDetails.setAccountNonLocked("F".equals(user.getStatus()) || "E".equals(user.getStatus()) ? false : true);
		webUserDetails.setAccountNonExpired(true);
		webUserDetails.setCredentialsNonExpired(true);
		
		webUserDetails.setAuthorities(authorities);
		return webUserDetails;
	}

	@Override
	public String onAuthenticationSuccess(Authentication authentication) {
		WebUserDetails jwtUser = (WebUserDetails) authentication.getPrincipal();
		
		// 登陆成功，登录失败次数归 0
		UserPO user = new UserPO();
		user.setUserCode(jwtUser.getUsername());
		UserPO tmp = userService.selectOne(user);
		
		user.setId(tmp.getId());
		user.setFailedCount(0);
		userService.updateNotNull(user);
		
		Map<String, Object> userInfo = new HashMap<>();
		userInfo.put("language", "zh_CN");
		userInfo.put("layout", jwtUser.getLayout());
		userInfo.put("theme", jwtUser.getTheme());
		userInfo.put("userCode", jwtUser.getUsername());
		userInfo.put("userName", jwtUser.getName());

		Map<String, Object> result = new HashMap<>();
		result.put(Constants.ACCESS_TOKEN, JWTUtils.sign(jwtUser.getUsername(), 1800));
		result.put(Constants.REFRESH_TOKEN, JWTUtils.sign(jwtUser.getUsername(), 3600));
		result.put(Constants.LOGIN_USER_INFO, userInfo);
		
		Map<String, Object> content = new HashMap<>();
		content.put("code", CodeUtil.INFO_200);
		content.put("data", result);
		content.put("message", "登陆成功");
		return JSON.toJSONString(content);
	}

	@Override
	public String onAuthenticationFailure(String username, AuthenticationException exception) {
		String code = CodeUtil.INFO_200;
		
		if(exception instanceof AccountExpiredException) {
			code = CodeUtil.USER_ACCOUNT_EXPIRED;
		} else if(exception instanceof DisabledException) {
			code = CodeUtil.USER_ACCOUNT_DISABLED;
		} else if(exception instanceof LockedException) {
			code = CodeUtil.USER_ACCOUNT_LOCKED;
		} else if(exception instanceof CredentialsExpiredException) {
			code = CodeUtil.USER_CREDENTIAL_EXPIRED;
		} else if(exception instanceof UsernameNotFoundException) {
			code = CodeUtil.USER_ACCOUNT_NOT_FOUND;
		} else if(exception instanceof BadCredentialsException) {
			code = CodeUtil.USER_CREDENTIAL_ERROR;
			onErrorPassword(username);
		}
		
		Map<String, String> content = new HashMap<>();
		content.put("code", code);
		content.put("message", "登录失败");
		return JSON.toJSONString(content);
	}
	
	/**
	 * 密码错误处理
	 * @param username
	 */
	private void onErrorPassword(String username) {
		Map<String, String> temp = new HashMap<>();
		temp.put("userCode", username);
		UserPO user = userService.selectOne(temp);
		
		if(null != user) {
			// 错误次数 + 1，错误次数达到最大值，冻结用户，更改用户状态
			user.setFailedCount(user.getFailedCount() + 1);
			if(user.getFailedCount() >= maxPasswordErrors) {
				user.setStatus(Constants.USER_STATUS_FROZEN);
			}
			userService.updateNotNull(user);
		}
	}

	@Override
	public String getUsernameByToken(String token) {
		if(!StringUtils.isEmpty(token)) {
			return JWTUtils.unsign(token, String.class);
		}
		return null;
	}

	@Override
	public String onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		Map<String, String> content = new HashMap<>();
		content.put("code", CodeUtil.INFO_200);
		content.put("message", "登出成功");
		return JSON.toJSONString(content);
	}
}
