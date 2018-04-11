package com.demo.externalservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ExternalApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExternalApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ExternalApplication.class, args);
	}
	
	@GetMapping("/welcome")
	public String sayWelcome() {
		LOGGER.info("Entering");
		return "WELCOME FROM DEFAULT: EXTERNAL APPLICATION";
	}

}
