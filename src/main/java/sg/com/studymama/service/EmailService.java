package sg.com.studymama.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	private static final Logger LOG = LoggerFactory.getLogger(EmailService.class);
	
	@Autowired
    private JavaMailSender sender;

	public void sendEmail(String email) throws MessagingException {
		LOG.info("Sending email to: " + email);
		MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo(email);
        helper.setText("This is a test email to: " + email);
        helper.setSubject("StudyMama Test Email");
        sender.send(message);
	}
}
