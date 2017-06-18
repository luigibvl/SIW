package it.uniroma3.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"it.uniroma3.security","it.uniroma3"})
@EnableJpaRepositories("it.uniroma3.repository")
@EntityScan("it.uniroma3.model")
public class SpringSecurityAuthenticationApplication extends SpringBootServletInitializer{
	
	//Per la costruzione del war
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringSecurityAuthenticationApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAuthenticationApplication.class, args);
	}
}
