package sg.com.studymama.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import sg.com.studymama.util.CryptoUtils;

@Service
public class EmailService {

	private static final Logger LOG = LoggerFactory.getLogger(EmailService.class);
	
	private final String baseUrl;

    @Autowired
    public EmailService(@Value("${base.url}") String baseUrl) {
        this.baseUrl = baseUrl;
    }
	
	@Autowired
    private JavaMailSender sender;

	public void testEmail(String email) throws MessagingException {
		LOG.info("Sending email to: " + email);
		MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo(email);
        helper.setText("This is a test email to: " + email);
        helper.setSubject("StudyMama Test Email");
        sender.send(message);
	}
	
	public void sendEmailVerifyLink(String email, String username) throws MessagingException {
		LOG.info("Sending verify email to: " + email + " username: " + username);
		MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo(email);
        String encryptUsername = CryptoUtils.encrypt(username);
        String link = baseUrl + "/verifyemail?data=" + encryptUsername;
        LOG.info(link);
        helper.setText("Please click this link to verify your email: " + link);
        helper.setSubject("StudyMama Email Verification");
        sender.send(message);
	}
}
