package cipher.keygen;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

public class KeyGeneratorTest {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		// Creating a KeyGenerator Instance
		String algorithm = "AES";
		KeyGenerator keyGenerator = KeyGenerator.getInstance( algorithm );
		
		// Initializing the KeyGenerator
		SecureRandom secureRandom = new SecureRandom();
		int keyBitSize = 256;
		keyGenerator.init( keyBitSize, secureRandom );
		
		// Generating a Key
		SecretKey secretKey = keyGenerator.generateKey();
		byte[] keys = secretKey.getEncoded();
		
		// Convert Key to Hex
		String key = DatatypeConverter.printHexBinary( keys );
		
		System.out.println( key );
	}
}
