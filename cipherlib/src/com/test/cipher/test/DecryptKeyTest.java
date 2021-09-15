package com.test.cipher.test;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.bind.DatatypeConverter;

import com.test.cipher.utils.CipherUtils;
import com.test.cipher.vo.ParamsVo;

public class DecryptKeyTest {

	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		CipherUtils cipherUtils = CipherUtils.getInstance();
		
		ParamsVo vo = new ParamsVo();
		vo.setCipher("9042075BC5D2FB498F824BE0EB790240");
		vo.setAlgo("AES");
		vo.setKeyVal("4AF90A15D171C6DEE7ED9E7F104C866B");

		byte[] plain = cipherUtils.decryptKey(vo);
		System.out.println(DatatypeConverter.printHexBinary(plain));
		
	}

}
