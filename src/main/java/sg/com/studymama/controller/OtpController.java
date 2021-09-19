package sg.com.studymama.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.warrenstrange.googleauth.GoogleAuthenticator;

@RestController
public class OtpController {
	
	private static final Logger LOG = LoggerFactory.getLogger(OtpController.class);

	@RequestMapping(value = "/generateOTP", method = RequestMethod.GET)
	public String generateOTP(String secret) {
		GoogleAuthenticator gAuth = new GoogleAuthenticator();
		int code = gAuth.getTotpPassword(secret);
		LOG.info("secret: " + secret + " otp " + code);
		return String.valueOf(code);
	}
	
	@RequestMapping(value = "/verifyOTP", method = RequestMethod.GET)
	public String verifyOTP(String secret, String otp) {
		LOG.info("secret: " + secret + " otp " + otp);
		boolean authorizedOtp = false;
		GoogleAuthenticator gAuth = new GoogleAuthenticator();
		authorizedOtp = gAuth.authorize(secret,
				Integer.parseInt(otp));
		LOG.info("authorizedOtp: " + authorizedOtp);
		return String.valueOf(authorizedOtp);
	}
}
