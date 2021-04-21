package sg.com.studymama.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	private static final Logger LOG = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping({ "/hellouser" })
	public String helloUser() {
		LOG.info("HELLO USER");
		return "Hello User";
	}

	@RequestMapping({ "/helloadmin" })
	public String helloAdmin() {
		LOG.info("HELLO ADMIN");
		return "Hello Admin";
	}
}
