package com.test.cipher.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtils {
	private static HashUtils hashUtils = null;

	private HashUtils() {}

	public static HashUtils getInstance() {
		if (hashUtils == null) {
			hashUtils = new HashUtils();
		}
		return hashUtils;
	}
	
	public byte[] getHash(String text, String algo, int size) throws NoSuchAlgorithmException, UnsupportedEncodingException {

		byte[] data = text.getBytes("UTF-8");
		MessageDigest md = MessageDigest.getInstance(algo);
		byte[] digest = md.digest(data);

		return digest;

	}
}
