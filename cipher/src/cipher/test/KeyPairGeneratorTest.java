package cipher.test;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.xml.bind.DatatypeConverter;

public class KeyPairGeneratorTest {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		// Creating a KeyPairGenerator Instance
		String algorithm = "RSA";
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance( algorithm );
		
		// Initializing the KeyPairGenerator
		int keySize = 2048;
		keyPairGenerator.initialize( keySize );
		
		// Generating a Key Pair
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		
		// Get Public Key & Private Key
		PublicKey pub = keyPair.getPublic();
		byte[] publicKeyByteArray = pub.getEncoded();
		
		PrivateKey pri = keyPair.getPrivate();
		byte[] privateKeyByteArray = pri.getEncoded();
		
		// Convert Key to Hex
		String publicKey = DatatypeConverter.printHexBinary( publicKeyByteArray );
		String privateKey = DatatypeConverter.printHexBinary( privateKeyByteArray );
		
		System.out.println( "public key : " + publicKey );
		System.out.println( "private key : " + privateKey );
		
		
	}
}
