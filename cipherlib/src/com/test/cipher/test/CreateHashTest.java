package com.test.cipher.test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import com.test.cipher.utils.HashUtils;

public class CreateHashTest {

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {

		/* Hash Algorithm Name
		 * MD2
		 * MD5
		 * SHA-1
		 * SHA-256
		 * SHA-384
		 * SHA-512
		 * */
		HashUtils hashUtils = HashUtils.getInstance();
		byte [] hash = hashUtils.getHash("exceptioninthreadmain", "SHA-1", 128);
		System.out.println(DatatypeConverter.printHexBinary(hash));
	}

}
