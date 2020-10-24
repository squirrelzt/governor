package com.governer.security.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "web", ignoreUnknownFields = true)
public class WebProperties {

	/**
	 * 登录请求 URL
	 */
	private String loginProcessingUrl = "/login";

	/**
	 * 登出请求 URL
	 */
	private String logoutUrl = "/logout";

	/**
	 * the parameter name. Defaults to "username".
	 */
	private String usernameParameter = "username";

	/**
	 * the parameter name. Defaults to "password".
	 */
	private String passwordParameter = "password";
	
	/**
	 * 授权
	 */
	private AuthorizeProperties authorize;

	public String getLoginProcessingUrl() {
		return loginProcessingUrl;
	}

	public void setLoginProcessingUrl(String loginProcessingUrl) {
		this.loginProcessingUrl = loginProcessingUrl;
	}

	public String getLogoutUrl() {
		return logoutUrl;
	}

	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}

	public String getUsernameParameter() {
		return usernameParameter;
	}

	public void setUsernameParameter(String usernameParameter) {
		this.usernameParameter = usernameParameter;
	}

	public String getPasswordParameter() {
		return passwordParameter;
	}

	public void setPasswordParameter(String passwordParameter) {
		this.passwordParameter = passwordParameter;
	}

	public AuthorizeProperties getAuthorize() {
		return (authorize == null) ? new AuthorizeProperties() : authorize;
	}

	public void setAuthorize(AuthorizeProperties authorize) {
		this.authorize = authorize;
	}
}
