package sg.com.studymama.controller;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sg.com.studymama.service.EmailService;

@RestController
public class TestController {

	private static final Logger LOG = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
    private EmailService emailService;

	@RequestMapping(value = "/hellouser", method = RequestMethod.GET)
	public String helloUser() {
		LOG.info("HELLO USER");
		return "Hello User";
	}

	@RequestMapping(value = "/helloadmin", method = RequestMethod.GET)
	public String helloAdmin() {
		LOG.info("HELLO ADMIN");
		return "Hello Admin";
	}

	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public @ResponseBody String greeting() {
		return "Hello, World. Welcome to StudyMama!";
	}

	@RequestMapping(value = "/demo", method = RequestMethod.GET)
	public @ResponseBody String demo() {
		return "Hello! This is a demo.";
	}

	@RequestMapping(value = "/sendemail", method = RequestMethod.GET)
	public String sendEmail(@RequestParam String email) {
		try {
			emailService.sendEmail(email);
		} catch (MessagingException e) {
			LOG.error("Send email error: ", e);
			return "Email sending failed";
		}
		return "Email sent successfully";
	}
}
