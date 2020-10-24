package com.governer.security.core;

import org.springframework.security.core.AuthenticationException;

/**
 * JWT 自定义异常
 * 
 * @author xp.zhao
 *
 */
public class NonJWTException extends AuthenticationException {

	private static final long serialVersionUID = 4087843651753798055L;

	public NonJWTException(String msg) {
		super(msg);
	}

	public NonJWTException(String msg, Throwable t) {
		super(msg, t);
	}

}
