package com.test.cipher.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;

public class KeyUtils {

	private static KeyUtils keyUtils = null;

	private KeyUtils() {
	}

	public static KeyUtils getInstance() {
		if (keyUtils == null) {
			keyUtils = new KeyUtils();
		}
		return keyUtils;
	}

	public byte[] generateKey(String algo, int keyLen) throws NoSuchAlgorithmException {

		KeyGenerator keyGenerator = KeyGenerator.getInstance(algo);

		SecureRandom secureRandom = new SecureRandom();

		keyGenerator.init(keyLen, secureRandom);

		return keyGenerator.generateKey().getEncoded();

	}

}
