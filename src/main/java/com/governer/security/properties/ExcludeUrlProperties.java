package com.governer.security.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *  
 * @author xp.zhao
 *
 */
@ConfigurationProperties(prefix = "web.authorize.exclude-urls", ignoreUnknownFields = true)
public class ExcludeUrlProperties {

	/**
	 * API 地址
	 */
	private String url;
	
	/**
	 * 方法
	 */
	private String method;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
}
