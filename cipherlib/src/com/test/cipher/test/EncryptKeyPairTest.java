package com.test.cipher.test;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.bind.DatatypeConverter;

import com.test.cipher.utils.CipherUtils;
import com.test.cipher.vo.ParamsVo;

public class EncryptKeyPairTest {

	public static void main(String[] args)
			throws InvalidKeyException, InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		
		CipherUtils cipherUtils = CipherUtils.getInstance();
		
		ParamsVo vo = new ParamsVo();
		vo.setPlain("helloiamtom");
		vo.setAlgo("RSA");
		vo.setKeyVal(
				"30819F300D06092A864886F70D010101050003818D0030818902818100AB14A0144753A0199ADAE63093E7CB94C6598BBBBF59ACCD8495F20C27FAB259C996CFDB946258A0A856625693EE54166F7EB78A648D5C11DD9B89B4E25348F57A5F5C964A472CB0C677CFC6517AC9A3C97F69FEF5DB19D10E525D55A0F527D3E8BDEFB82ABE81154853096C9A117A328A47789697B8A05FEE3B1D95754267330203010001");

		byte[] cipher = cipherUtils.encryptKeyPair(vo);
		System.out.println(DatatypeConverter.printHexBinary(cipher));
	}

}
