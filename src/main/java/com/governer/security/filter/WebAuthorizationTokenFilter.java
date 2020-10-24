package com.governer.security.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.governer.security.config.annotation.web.RequestMatchers;
import com.governer.security.core.NonJWTException;
import com.governer.security.core.userdetails.WebAuthenticationService;
import com.governer.security.properties.ExcludeUrlProperties;
import com.governer.security.properties.WebProperties;
import com.governer.security.util.SpringContextUtil;

/**
 * token 校验过滤器
 * 
 * @author xp.zhao
 *
 */
@Component
public class WebAuthorizationTokenFilter extends OncePerRequestFilter {

	@Autowired
	private WebProperties webProperties;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		boolean ignore = ignore(request);
		if(!ignore) {
			WebAuthenticationService webAuthenticationService = SpringContextUtil.getBean(WebAuthenticationService.class);
			
			String token = request.getHeader(webProperties.getAuthorize().getTokenName());
			if(StringUtils.isEmpty(token)) {
				throw new NonJWTException("Token parameter not found in request header!");
			} else {
				String username = webAuthenticationService.getUsernameByToken(token);
				if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
					UserDetails userDetails = webAuthenticationService.loadUserByUsername(username);
					// 生成通过认证
		            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
		            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		            // 将权限写入本次会话
		            SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
		}

		chain.doFilter(request, response);
	}
	
	/**
	 * 忽略TOKEN校验，登录地址、特殊过滤地址
	 * 
	 * @param request
	 * @return
	 */
	private boolean ignore(HttpServletRequest request) {

		// 登录地址忽略
		AntPathRequestMatcher loginMatcher = new AntPathRequestMatcher(webProperties.getLoginProcessingUrl(), HttpMethod.POST.name());
		if(loginMatcher.matches(request)) 
			return true;
		
		// 自定义忽略地址
		List<ExcludeUrlProperties> list = webProperties.getAuthorize().getExcludeUrls();
		for(ExcludeUrlProperties excludeUrl : list) {
			String pattern = excludeUrl.getUrl();
			String[] antPatterns = pattern.contains(",") ? pattern.split(",") : new String[] {pattern};
			
			List<RequestMatcher> matchers = new ArrayList<>();
			if(StringUtils.isEmpty(excludeUrl.getMethod())) {
				matchers = RequestMatchers.antMatchers(antPatterns);
			} else {
				matchers = RequestMatchers.antMatchers(HttpMethod.resolve(excludeUrl.getMethod()), antPatterns);
			}
			
			for(RequestMatcher requestMatcher : matchers) {
				if(requestMatcher.matches(request))
					return true;
			}
		}
		
		return false;
	}
}
