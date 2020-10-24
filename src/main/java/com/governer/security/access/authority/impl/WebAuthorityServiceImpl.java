package com.governer.security.access.authority.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.governer.domain.po.ResourcePO;
import com.governer.domain.po.RolePO;
import com.governer.domain.vo.request.ResourceRequestVO;
import com.governer.security.access.authority.WebAuthorityService;
import com.governer.security.config.annotation.web.RequestMatchers;
import com.governer.service.security.ResourceService;
import com.governer.service.security.ResourceType;
import com.governer.service.security.RoleService;

@Service
public class WebAuthorityServiceImpl implements WebAuthorityService {

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ResourceService resourceService;
	
	@Override
	public List<ConfigAttribute> loadApiAuthorities(HttpServletRequest request) {
		ResourceRequestVO temp = new ResourceRequestVO();
		temp.setResourceType(ResourceType.URL.name());
		temp.setResourceMethod(request.getMethod());
		List<ResourcePO> resources = resourceService.selectList(temp);

		// 1、对请求路径匹配资源
		List<ResourcePO> matchs = new ArrayList<>();
		for(ResourcePO resource : resources) {
			String[] antPatterns = new String[] {resource.getResourceUrl()};
			List<RequestMatcher> matchers = RequestMatchers.antMatchers(HttpMethod.resolve(resource.getResourceMethod()), antPatterns);

			for(RequestMatcher requestMatcher : matchers) {
				if(requestMatcher.matches(request))
					matchs.add(resource);
			}
		}

		// 2、根据资源确定角色
		if(!CollectionUtils.isEmpty(matchs)) {
			Map<String, Object> params = new HashMap<>();
			params.put("resources", matchs);
			List<RolePO> roles = roleService.selectByResources(params);
			if(!CollectionUtils.isEmpty(roles)) {
		        List<String> codes = roles.stream().map(RolePO::getRoleCode).collect(Collectors.toList());
				String[] values = codes.toArray(new String[codes.size()]);
	            return SecurityConfig.createList(values);
			}
		}
		return null;
	}

	@Override
	public String getFilterSql(String privId, String alias) {
		return null;
	}

}
