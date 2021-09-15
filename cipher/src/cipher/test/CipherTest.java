package cipher.test;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.xml.bind.DatatypeConverter;

public class CipherTest {
	public static void main(String[] args) 
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		
		// Creating a Cipher
		String algorithm = "ARIA";
		Cipher cipher = Cipher.getInstance( algorithm );
		
		// Initializing a Cipher
		KeyGenerator keyGenerator = KeyGenerator.getInstance( "AES" );
		SecureRandom secureRandom = new SecureRandom();
		int keyBitSize = 256;
		keyGenerator.init( keyBitSize, secureRandom );
		
		Key key = keyGenerator.generateKey();
		cipher.init( Cipher.ENCRYPT_MODE, key );
		
		byte[] plainText = "hellojava".getBytes();
		byte[] cipherText = cipher.doFinal( plainText );
		
		String cip = DatatypeConverter.printHexBinary( cipherText );
		System.out.println( cip );
	}
}
