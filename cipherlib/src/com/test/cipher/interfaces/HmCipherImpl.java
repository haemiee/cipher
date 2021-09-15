package com.test.cipher.interfaces;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.bind.DatatypeConverter;

import com.test.cipher.utils.CipherUtils;
import com.test.cipher.utils.HashUtils;
import com.test.cipher.utils.KeyPairUtils;
import com.test.cipher.utils.KeyUtils;
import com.test.cipher.vo.ParamsVo;

public class HmCipherImpl implements HmCipher {
	
	private CipherUtils cipherUtils = CipherUtils.getInstance();
			
	@Override
	public String getHash(String msg, String algorithm, int length) 
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		HashUtils hashUtils = HashUtils.getInstance();
		byte [] hash = hashUtils.getHash(msg, "SHA-1", length);
		return DatatypeConverter.printHexBinary(hash);
		
	}

	@Override
	public String createKey(String algorithm, int keyLength) throws Exception {
		KeyUtils keyUtils = KeyUtils.getInstance();
		byte [] keys = keyUtils.generateKey(algorithm, keyLength);
		return DatatypeConverter.printHexBinary(keys);
	}

	@Override
	public String encryptKey(String plainText, String algorithm, String keyValue) 
			throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException {
		ParamsVo vo = new ParamsVo();
		vo.setPlain(plainText);
		vo.setAlgo(algorithm);
		vo.setKeyVal(keyValue);
		
		byte[] cipher = cipherUtils.encryptKey(vo);
		return DatatypeConverter.printHexBinary(cipher);
	}

	@Override
	public String decryptKey(String cipherText, String algorithm, String keyValue) 
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		ParamsVo vo = new ParamsVo();
		vo.setCipher(cipherText);
		vo.setAlgo(algorithm);
		vo.setKeyVal(keyValue);
		
		byte[] plain = cipherUtils.decryptKey(vo);
		return DatatypeConverter.printHexBinary(plain);
	}

	@Override
	public Map<String, String> createKeyPair(String algorithm, int keyLength) throws NoSuchAlgorithmException {
		KeyPairUtils keyPairUtils = KeyPairUtils.getInstance();
		Map<String, byte []> keyPair = keyPairUtils.generateKeyPair(algorithm, keyLength);
		
		Map<String, String> res = new HashMap<String, String>();
		res.put("Public Key", DatatypeConverter.printHexBinary(keyPair.get("pub")));
		res.put("Private Key", DatatypeConverter.printHexBinary(keyPair.get("pri")));
		
		return res;
	}
	
	@Override
	public String encryptKeyPair(String plainText, String algorithm, String keyValue) throws IOException, InvalidKeyException, InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException {
		ParamsVo vo = new ParamsVo();
		vo.setPlain(plainText);
		vo.setAlgo(algorithm);
		vo.setKeyVal(keyValue);
		
		byte [] cipher = cipherUtils.encryptKeyPair(vo);
		return DatatypeConverter.printHexBinary(cipher);
	}

	@Override
	public String decryptKeyPair(String cipherText, String algorithm, String keyValue) throws InvalidKeyException, InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		ParamsVo vo = new ParamsVo();
		vo.setCipher(cipherText);
		vo.setAlgo(algorithm);
		vo.setKeyVal(keyValue);
		
		byte [] plain = cipherUtils.decryptKeyPair(vo);
		return DatatypeConverter.printHexBinary(plain);
	}

}
