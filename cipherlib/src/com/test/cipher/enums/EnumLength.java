package com.test.cipher.enums;

public enum EnumLength {
	
	_128(128),
	_192(192),
	_256(256),
	_512(512);
	
	private int length;
	
	EnumLength( int length ) {
		this.length = length;
	}

	public int getLength() {
		return length;
	}
	
}
