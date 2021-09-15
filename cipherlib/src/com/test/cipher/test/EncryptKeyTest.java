package com.test.cipher.test;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.bind.DatatypeConverter;

import com.test.cipher.utils.CipherUtils;
import com.test.cipher.vo.ParamsVo;

public class EncryptKeyTest {

	public static void main(String[] args) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException {
		
		CipherUtils cipherUtils = CipherUtils.getInstance();
		
		ParamsVo vo = new ParamsVo();
		vo.setPlain("helloiamtom");
		vo.setAlgo("AES");
		vo.setKeyVal("4AF90A15D171C6DEE7ED9E7F104C866B");
		
		byte[] cipher = cipherUtils.encryptKey(vo);
		System.out.println(DatatypeConverter.printHexBinary(cipher));
		
	}

}
