package sg.com.studymama;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class StudymamaApplication {
	
	private static final Logger LOG = LoggerFactory.getLogger(StudymamaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(StudymamaApplication.class, args);
		LOG.info("Study Mama Application Started");
	}
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info().title("Studymama API")
				.description("This is a Studymama server created using springdocs - a library for OpenAPI 3 with spring boot.")
				.termsOfService("http://swagger.io/terms/")
				.license(new License().name("Apache 2.0")
						.url("http://springdoc.org")));
	}

}
