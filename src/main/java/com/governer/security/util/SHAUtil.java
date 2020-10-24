package com.governer.security.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SHAUtil {

	private static final Logger logger = LoggerFactory.getLogger(SHAUtil.class);

	/**
	 * 加密
	 * 
	 * @param data
	 * @return
	 */
	public static String encrypt(String data) {
		StringBuffer hexstr = new StringBuffer();

		try {
			byte[] digest = encryptSHA(data.getBytes());

			String shaHex = "";
			for (int i = 0; i < digest.length; i++) {
				shaHex = Integer.toHexString(digest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexstr.append(0);
				}
				hexstr.append(shaHex);
			}
		} catch (Exception e) {
			logger.error("加密异常", e);
		}

		return hexstr.toString();
	}

	private static byte[] encryptSHA(byte[] data) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return md != null ? md.digest(data) : null;
	}
}
