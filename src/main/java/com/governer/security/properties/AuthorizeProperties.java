package com.governer.security.properties;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpMethod;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@ConfigurationProperties(prefix = "web.authorize", ignoreUnknownFields = true)
public class AuthorizeProperties {

	/**
	 * 请求头 token 参数名
	 */
	private String tokenName = "token";

	/**
	 * 精确权限模式，默认 false；
	 * <p>true：精确权限，仅拥有分配的权限</p>
	 * <p>false：模糊权限，拥有分配的权限、不需要分配的权限</p>
	 * <p>例：查看个人信息，所有登录人员均可访问；精确模式下，需要分配【个人信息 API】给每个需要的人员；模糊模式下，默认全部人员可访问；</p>
	 */
	private boolean precise = false;

	/**
	 * 权限忽略地址
	 * url 是匹配地址，处理中创建 {@link AntPathRequestMatcher}，具体使用参考 {@link AntPathMatcher}
	 * method 请求方法
	 */
	private List<ExcludeUrlProperties> excludeUrls;

	public String getTokenName() {
		return tokenName;
	}

	public void setTokenName(String tokenName) {
		this.tokenName = tokenName;
	}
	
	public boolean getPrecise() {
		return precise;
	}

	public void setPrecise(boolean precise) {
		this.precise = precise;
	}

	public List<ExcludeUrlProperties> getExcludeUrls() {
		return excludeUrls == null ? new ArrayList<>() : excludeUrls;
	}

	public void setExcludeUrls(List<ExcludeUrlProperties> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	/**
	 * 解析 excludeUrl 获取整理后的过滤路径
	 * 
	 * @return
	 */
	public String[] getPatterns(HttpMethod httpMethod) {
		List<ExcludeUrlProperties> excludeUrls = getExcludeUrls();

		String temp = "/sunline-abcd";
		if(!CollectionUtils.isEmpty(excludeUrls)) {
			for (ExcludeUrlProperties excludeUrl : excludeUrls) {
				if (httpMethod != null && httpMethod.matches(excludeUrl.getMethod())) {
					temp = temp + "," + excludeUrl.getUrl();
				}
				if (httpMethod == null && StringUtils.isEmpty(excludeUrl.getMethod())) {
					temp = temp + "," + excludeUrl.getUrl();
				}
			}
		}

		String[] patterns = temp.contains(",") ? temp.split(",") : new String[] { temp };
		for (int i = 0; i < patterns.length; i++) {
			patterns[i] = patterns[i].trim();
		}
		return patterns;
	}
}
