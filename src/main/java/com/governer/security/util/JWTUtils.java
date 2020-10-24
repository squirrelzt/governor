package com.governer.security.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTSigner.Options;
import com.auth0.jwt.JWTVerifier;


public abstract class JWTUtils implements Serializable {

	private static final long serialVersionUID = 936896807716824061L;

	private static final String SECRET = "!@#$%^12345@$%^&*ertyuERTYUIfghjVBNGH";

	private static final String BODY = "body";

	public static final <T> String sign(T object, int expirySeconds) {
		try {
			final JWTSigner signer = new JWTSigner(SECRET);
			final Map<String, Object> claims = new HashMap<>();
			claims.put(BODY, object);
			Options options = new Options();
			options.setExpirySeconds(expirySeconds);
			return signer.sign(claims, options);
		} catch (Exception e) {
			throw new RuntimeException("签名异常：" + e);
		}
	}

	public static final <T> T unsign(String token, Class<T> clazz) {
		final JWTVerifier verifier = new JWTVerifier(SECRET);
		try {
			final Map<String, Object> claims = verifier.verify(token);
			Object value = claims.get(BODY);
			if (null == value) {
				throw new RuntimeException("claims must be containsKey " + BODY);
			}
			return JSON.parseObject(JSON.toJSONString(value), clazz);
		} catch (Exception e) {
			throw new RuntimeException("校验签名异常：" + e);
		}
	}
}
