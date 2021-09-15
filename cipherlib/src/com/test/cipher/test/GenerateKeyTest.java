package com.test.cipher.test;

import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import com.test.cipher.utils.KeyUtils;

public class GenerateKeyTest {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		KeyUtils keyUtils = KeyUtils.getInstance();
		
		byte[] b = keyUtils.generateKey("AES", 128);
//		byte[] b = KeyUtils.generateKey("AES", 192);
//		byte[] b = KeyUtils.generateKey("AES", 256);
		
		System.out.println(DatatypeConverter.printHexBinary(b));
		
	}
	
}
