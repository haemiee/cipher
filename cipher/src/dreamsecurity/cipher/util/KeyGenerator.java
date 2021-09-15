package dreamsecurity.cipher.util;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.spec.ECParameterSpec;

import com.dreamsecurity.jcaos.crypto.math.ec.ECNamedCurveTable;

public class KeyGenerator {
	
	private KeyGenerator() {
		throw new AssertionError();
	}
	
	public static byte[] createKey( int keyLength ) throws IOException, ClassNotFoundException, NoSuchAlgorithmException {
		byte[] randomBytes = new byte[ keyLength ];
		
		SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA256DRBG");
		secureRandomGenerator.nextBytes(randomBytes);

		return randomBytes;
	}
	
	public static KeyPair createKeyPair( String keyAlgorithm, int keyLength ) throws NoSuchAlgorithmException, NoSuchProviderException {
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance( keyAlgorithm, "JCAOS" );
		
		// 2020. 08. 12 
		// 암호팀.지보영B: Key(Pair)Generator의 Provider를 JCAOS를 지정할 경우, 엔트로피 수집 후, SHA256DRBG를 통해 암호키 생성
        keyGen.initialize( keyLength, new SecureRandom() );
		
		return keyGen.generateKeyPair();
	}
	
	public static KeyPair createEcKeyPair( String keyAlgorithm, String curve ) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchProviderException {
		KeyPairGenerator keyGen;
		ECParameterSpec ecGenSpec;
		
		try {
			keyGen = KeyPairGenerator.getInstance( keyAlgorithm, "JCAOS" );
			ecGenSpec = ECNamedCurveTable.getParameterSpec( curve );
			
			keyGen.initialize( ecGenSpec );
		} catch ( InvalidAlgorithmParameterException e ) {
			keyGen = KeyPairGenerator.getInstance( keyAlgorithm, "JCAOS" );
			ecGenSpec = ECNamedCurveTable.getParameterSpec( curve );
			
			keyGen.initialize( ecGenSpec );
		}
		
		return keyGen.generateKeyPair();
	}
}