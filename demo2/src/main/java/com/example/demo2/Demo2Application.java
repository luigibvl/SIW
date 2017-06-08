package com.example.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
@ComponentScan({"com.examples.demo2","it.uniroma3"})
@EnableJpaRepositories("it.uniroma3.repository")
@EntityScan("it.uniroma3.model")

public class Demo2Application {
	
	

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}
}


// per configurare una nuova porta scrivere all'interno del file application.properties  " server.port=8081   " (per esempio)