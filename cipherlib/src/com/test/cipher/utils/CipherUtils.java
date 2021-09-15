package com.test.cipher.utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import com.test.cipher.vo.ParamsVo;

public class CipherUtils {
	private static CipherUtils ciperUtils = null;

	private CipherUtils() {}

	public static CipherUtils getInstance() {
		if (ciperUtils == null) {
			ciperUtils = new CipherUtils();
		}
		return ciperUtils;
	}

	public byte[] encryptKey(ParamsVo vo) throws IllegalBlockSizeException, BadPaddingException,
			UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {

		SecretKeySpec encKey = new SecretKeySpec(vo.getKeyVal().getBytes(), vo.getAlgo());

		Cipher cipher = Cipher.getInstance(vo.getAlgo());
		cipher.init(Cipher.ENCRYPT_MODE, encKey);

		byte[] plainText = vo.getPlain().getBytes("UTF-8");
		byte[] cipherText = cipher.doFinal(plainText);

		return cipherText;

	}

	public byte[] decryptKey(ParamsVo vo) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

		SecretKeySpec encKey = new SecretKeySpec(vo.getKeyVal().getBytes(), vo.getAlgo());

		Cipher cp = Cipher.getInstance(vo.getAlgo());
		cp.init(Cipher.DECRYPT_MODE, encKey);

		byte[] data = DatatypeConverter.parseHexBinary(vo.getCipher());
		byte[] plain = cp.doFinal(data);

		return plain;

	}

	public byte[] encryptKeyPair(ParamsVo vo)
			throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException,
			UnsupportedEncodingException, InvalidKeyException, NoSuchPaddingException {

		PublicKey pubkey = KeyFactory.getInstance(vo.getAlgo())
				.generatePublic(new X509EncodedKeySpec(DatatypeConverter.parseHexBinary(vo.getKeyVal())));

		Cipher cipher = Cipher.getInstance(vo.getAlgo());
		cipher.init(Cipher.ENCRYPT_MODE, pubkey);

		byte[] plainText = vo.getPlain().getBytes("UTF-8");
		byte[] cipherText = cipher.doFinal(plainText);

		return cipherText;
	}

	public byte[] decryptKeyPair(ParamsVo vo) throws InvalidKeySpecException, NoSuchAlgorithmException,
			InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {

		PrivateKey prikey = KeyFactory.getInstance(vo.getAlgo())
				.generatePrivate(new PKCS8EncodedKeySpec(DatatypeConverter.parseHexBinary(vo.getKeyVal())));

		Cipher cipher = Cipher.getInstance(vo.getAlgo());
		cipher.init(Cipher.DECRYPT_MODE, prikey);

		byte[] data = DatatypeConverter.parseHexBinary(vo.getCipher());
		byte[] plain = cipher.doFinal(data);

		return plain;

	}
}
