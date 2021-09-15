package com.test.cipher.interfaces;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * 대칭키/비대칭키의 생성과 암복호화 기능을 제공하는 구현체입니다.
 * @author haemi2ee
 *
 */

public interface HmCipher {
	/**
	 * 해시값을 계산하는 함수
	 * 
	 * @param msg 일방향 해시 함수의 입력값
	 * @param algorithm 해시 알고리즘 ex) MD2, MD5, SHA-1, SHA-256, SHA-384, SHA-512
	 * @param length 해시값의 길이 ex) 128, 256, 512
	 * @return 해시값(hex)
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public String getHash(String msg, String algorithm, int length) throws NoSuchAlgorithmException, UnsupportedEncodingException;
	/**
	 * 대칭키를 생성하는 함수
	 * 
	 * @param algorithm 키 생성 알고리즘 ex) AES
	 * @param keyLength  키 길이 ex) 128, 192, 512
	 * @return 키(hex)
	 * @throws Exception
	 */
	public String createKey(String algorithm, int keyLength) throws Exception;
	/**
	 * 대칭키를 사용하여 암호화 기능을 제공하는 함수
	 * 
	 * @param plainText 평문
	 * @param algorithm 대칭키 암호 알고리즘 ex) AES
	 * @param keyValue 대칭키 값(hex) 
	 * @return 암호문(hex)
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 */
	public String encryptKey(String plainText, String algorithm, String keyValue) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException;
	/**
	 * 대칭키를 사용하여 복호화 기능을 제공하는 함수
	 * 
	 * @param cipherText 암호문(hex)
	 * @param algorithm 대칭키 암호 알고리즘 ex) AES
	 * @param keyValue 대칭키 값(hex)
	 * @return 평문(hex)
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public String decryptKey(String cipherText, String algorithm, String keyValue) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException;
	/**
	 * 비대칭키를 생성하는 함수
	 * 
	 * @param algorithm 키 생성 알고리즘 ex) RSA
	 * @param keyLength 키 길이 ex) 128, 192, 256, 512
	 * @return 공개키(key: Public Key)와 개인키(key: Private Key)를 담고있는 Map
	 * @throws NoSuchAlgorithmException
	 */
	public Map<String, String> createKeyPair(String algorithm, int keyLength) throws NoSuchAlgorithmException;
	/**
	 * 비대칭키를 사용하여 암호화 기능을 제공하는 함수
	 * 
	 * @param plainText 평문
	 * @param algorithm 공개키 암호 알고리즘 ex) RSA
	 * @param keyValue 공개키 값(hex)
	 * @return 암호문(hex)
	 * @throws IOException
	 * @throws InvalidKeyException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchAlgorithmException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws NoSuchPaddingException
	 */
	public String encryptKeyPair(String plainText, String algorithm, String keyValue) throws IOException, InvalidKeyException, InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException;
	/**
	 * 비대칭키를 사용하여 복호화 기능을 제공하는 함수
	 * 
	 * @param cipherText 암호문(hex)
	 * @param algorithm 공개키 암호 알고리즘 ex) RSA
	 * @param keyValue 개인키 값(hex)
	 * @return 평문(hex)
	 * @throws InvalidKeyException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public String decryptKeyPair(String cipherText, String algorithm, String keyValue) throws InvalidKeyException, InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException;
	
}
