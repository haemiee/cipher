package com.test.cipher.utils;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class KeyPairUtils {
	private static KeyPairUtils keyPairUtils = null;

	private KeyPairUtils() {
	}

	public static KeyPairUtils getInstance() {
		if (keyPairUtils == null) {
			keyPairUtils = new KeyPairUtils();
		}
		return keyPairUtils;
	}

	public Map<String, byte[]> generateKeyPair(String algo, int keyLen) throws NoSuchAlgorithmException {
		Map<String, byte[]> res = new HashMap<String, byte[]>();

		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algo);
		keyPairGenerator.initialize(keyLen * 8);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();

		byte[] pri = keyPair.getPrivate().getEncoded();
		byte[] pub = keyPair.getPublic().getEncoded();

		res.put("pri", pri);
		res.put("pub", pub);

		return res;

	}

}
