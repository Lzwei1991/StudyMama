package sg.com.studymama.util;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CryptoUtils {

	private static final Logger LOG = LoggerFactory.getLogger(CryptoUtils.class);
	private static final String ALGO = "AES";
	private static final byte[] keyValue = new byte[] { 'S', 'T', 'U', 'D', 'Y', 'M', 'A', 'M', 'A', '1', '2', '3', '4', '5', '6', '7' };

	/**
	 * Encrypt a string using AES encryption algorithm.
	 *
	 * @param pwd the password to be encrypted
	 * @return the encrypted string
	 */
	public static String encrypt(String data) {
		String encodedPwd = "";
		try {
			Key key = generateKey();
			Cipher c = Cipher.getInstance(ALGO);
			c.init(Cipher.ENCRYPT_MODE, key);
			byte[] encVal = c.doFinal(data.getBytes());
			encodedPwd = Base64.getEncoder().encodeToString(encVal);

		} catch (Exception e) {
			LOG.error("encrypt", e);
		}
		return encodedPwd;
	}

	/**
	 * Decrypt a string with AES encryption algorithm.
	 *
	 * @param encryptedData the data to be decrypted
	 * @return the decrypted string
	 */
	public static String decrypt(String encryptedData) {
		String decodedPWD = "";
		try {
			Key key = generateKey();
			Cipher c = Cipher.getInstance(ALGO);
			c.init(Cipher.DECRYPT_MODE, key);
			byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
			byte[] decValue = c.doFinal(decordedValue);
			decodedPWD = new String(decValue);

		} catch (Exception e) {
			LOG.error("decrypt", e);
		}
		return decodedPWD;
	}

	/**
	 * Generate a new encryption key.
	 */
	private static Key generateKey() {
		SecretKeySpec key = new SecretKeySpec(keyValue, ALGO);
		return key;
	}
}
