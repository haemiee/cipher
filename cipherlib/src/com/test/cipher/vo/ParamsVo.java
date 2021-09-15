package com.test.cipher.vo;

public class ParamsVo {

	private String plain;
	private String cipher;
	private String keyVal;
	private int keyLen;
	private String algo;
	
	public String getPlain() {
		return plain;
	}
	public void setPlain(String plain) {
		this.plain = plain;
	}
	public String getCipher() {
		return cipher;
	}
	public void setCipher(String cipher) {
		this.cipher = cipher;
	}
	public String getKeyVal() {
		return keyVal;
	}
	public void setKeyVal(String keyVal) {
		this.keyVal = keyVal;
	}
	public int getKeyLen() {
		return keyLen;
	}
	public void setKeyLen(int keyLen) {
		this.keyLen = keyLen;
	}
	public String getAlgo() {
		return algo;
	}
	public void setAlgo(String algo) {
		this.algo = algo;
	}
	
}
