package sg.com.studymama.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.warrenstrange.googleauth.GoogleAuthenticator;

@Service
public class OtpService {
	
	private static final Logger LOG = LoggerFactory.getLogger(OtpService.class);

	public String testGenerateOTP(String secret) {
		GoogleAuthenticator gAuth = new GoogleAuthenticator();
		int code = gAuth.getTotpPassword(secret);
		LOG.info("secret: " + secret + " otp " + code);
		return String.valueOf(code);
	}
	
	public String testVerifyOTP(String secret, String otp) {
		LOG.info("secret: " + secret + " otp " + otp);
		boolean authorizedOtp = false;
		GoogleAuthenticator gAuth = new GoogleAuthenticator();
		authorizedOtp = gAuth.authorize(secret,
				Integer.parseInt(otp));
		LOG.info("authorizedOtp: " + authorizedOtp);
		return String.valueOf(authorizedOtp);
	}
}
