package com.test.cipher.test;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import com.test.cipher.utils.KeyPairUtils;

public class GenerateKeyPairTest {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		KeyPairUtils keyPairUtils = KeyPairUtils.getInstance();
		
		Map<String, byte []> map = keyPairUtils.generateKeyPair("RSA", 128);
//		Map<String, byte []> map = KeyPairUtils.generateKeyPair("RSA", 192);
//		Map<String, byte []> map = KeyPairUtils.generateKeyPair("RSA", 256);
//		Map<String, byte []> map = KeyPairUtils.generateKeyPair("RSA", 512);
		
		System.out.println("pub : " + DatatypeConverter.printHexBinary(map.get("pub")));
		System.out.println("pri : " + DatatypeConverter.printHexBinary(map.get("pri")));
	}
}
