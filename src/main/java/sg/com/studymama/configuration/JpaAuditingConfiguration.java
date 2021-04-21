package sg.com.studymama.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditor")
public class JpaAuditingConfiguration {

    @Bean
    public AuditorAware<String> auditor() {
        return () -> Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}