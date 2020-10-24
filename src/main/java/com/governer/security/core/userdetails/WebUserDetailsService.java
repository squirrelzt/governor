package com.governer.security.core.userdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class WebUserDetailsService implements UserDetailsService {
	
	@Autowired
	private WebAuthenticationService webAuthenticationService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDetails = webAuthenticationService.loadUserByUsername(username);
		if(userDetails == null) {
			throw new UsernameNotFoundException("Username " + username + " not found");
		}
		return userDetails;
	}

}
