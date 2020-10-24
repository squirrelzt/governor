package com.governer.security.config.annotation.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.governer.security.access.DaoAccessDecisionManager;
import com.governer.security.access.intercept.DaoSecurityInterceptor;
import com.governer.security.filter.WebAuthorizationTokenFilter;
import com.governer.security.properties.WebProperties;
import com.governer.security.web.WebAuthenticationEntryPoint;
import com.governer.security.web.access.WebAccessDeniedHandlerImpl;
import com.governer.security.web.access.intercept.DaoSecurityMetadataSource;
import com.governer.security.web.authentication.WebAuthenticationFailureHandler;
import com.governer.security.web.authentication.WebAuthenticationSuccessHandler;
import com.governer.security.web.authentication.WebUsernamePasswordAuthenticationFilter;
import com.governer.security.web.authentication.logout.WebLogoutHandler;
import com.governer.security.web.authentication.logout.WebLogoutSuccessHandler;

/**
 * Security 配置（重要）
 * <p>
 * 1、启动时加载
 * </p>
 * <p>
 * 2、自定义登录认证
 * </p>
 * <p>
 * 3、自定义授权过滤器
 * </p>
 * 
 * @author xp.zhao
 *
 */
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	private WebAuthenticationEntryPoint unauthorizedHandler;

	@Autowired
	private WebAccessDeniedHandlerImpl webAccessDeniedHandlerImpl;

	@Autowired
	private WebAuthorizationTokenFilter authenticationTokenFilter;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private WebAuthenticationSuccessHandler webAuthenticationSuccessHandler;

	@Autowired
	private WebAuthenticationFailureHandler webAuthenticationFailureHandler;
	
	@Autowired
	private WebLogoutSuccessHandler webLogoutSuccessHandler;

	@Autowired
	private WebProperties webProperties;
	
	@Autowired
	private DaoSecurityMetadataSource daoSecurityMetadataSource;

	@Autowired
	private DaoAccessDecisionManager daoAccessDecisionManager;

	@Override

	protected void configure(HttpSecurity http) throws Exception {


		// 防止 iframe 造成跨域
		http.headers().frameOptions().disable();

		// 禁用 CSRF
		http.csrf().disable();

		// 不创建、使用会话
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// 认证异常、授权异常
		http.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).accessDeniedHandler(webAccessDeniedHandlerImpl);

		// 过滤请求
		http.authorizeRequests()
				// 忽略地址
				.antMatchers(webProperties.getAuthorize().getPatterns(null)).anonymous()
				.antMatchers(HttpMethod.GET, webProperties.getAuthorize().getPatterns(HttpMethod.GET)).permitAll()
				.antMatchers(HttpMethod.POST, webProperties.getAuthorize().getPatterns(HttpMethod.POST)).permitAll()
				.antMatchers(HttpMethod.PUT, webProperties.getAuthorize().getPatterns(HttpMethod.PUT)).permitAll()
				.antMatchers(HttpMethod.DELETE, webProperties.getAuthorize().getPatterns(HttpMethod.DELETE)).permitAll()
				.antMatchers(HttpMethod.OPTIONS, webProperties.getAuthorize().getPatterns(HttpMethod.OPTIONS)).permitAll()
				// 所有请求都需要认证
				.anyRequest().authenticated().and()
				// 表单登录模式（特殊处理，允许 JSON 方式登录）
				.formLogin().and()
				// 登出
				.logout().logoutUrl(webProperties.getLogoutUrl()).addLogoutHandler(new WebLogoutHandler()).logoutSuccessHandler(webLogoutSuccessHandler);

		// 认证过滤器
		http.addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
		// 自定义登录过滤器
		http.addFilterAt(webUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		// 自定义API过滤器
		http.addFilterBefore(daoSecurityInterceptor(), FilterSecurityInterceptor.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	@Bean
	public WebUsernamePasswordAuthenticationFilter webUsernamePasswordAuthenticationFilter() throws Exception {
		WebUsernamePasswordAuthenticationFilter filter = new WebUsernamePasswordAuthenticationFilter();
		filter.setAuthenticationManager(authenticationManagerBean());
		filter.setAuthenticationSuccessHandler(webAuthenticationSuccessHandler);
		filter.setAuthenticationFailureHandler(webAuthenticationFailureHandler);
		filter.setFilterProcessesUrl(webProperties.getLoginProcessingUrl());

		if (null != webProperties.getUsernameParameter())
			filter.setUsernameParameter(webProperties.getUsernameParameter());

		return filter;
	}

	@Bean
	public DaoSecurityInterceptor daoSecurityInterceptor() {
		DaoSecurityInterceptor daoInterceptor = new DaoSecurityInterceptor();
		daoInterceptor.setSecurityMetadataSource(daoSecurityMetadataSource);
		// 设置认证决策管理器
		daoInterceptor.setAccessDecisionManager(daoAccessDecisionManager);
		return daoInterceptor;
	}
}
