package com.demo.integrationservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ImportResource("classpath:/META-INF/spring/integration/outbound-config.xml")
public class IntegrationApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationApplication.class);

	@Autowired
	@Qualifier("serviceGateway")
	ServiceGateway serviceGateway;

	public static void main(String[] args) {
		SpringApplication.run(IntegrationApplication.class, args);
	}

	@GetMapping("/callExternalServiceViaGateway")
	public String sendViaGateway() {
		LOGGER.info("Entering");
		LOGGER.info("Making Call to serviceGateway");
		String response = invokeExternalServiceViaGateway();
		LOGGER.info("Obtained response from serviceGateway: " + response);
		LOGGER.info("Leaving");
		return response;
	}

	private String invokeExternalServiceViaGateway() {
		LOGGER.info("Entering");
		String responseMsg = serviceGateway.getCustomMessage();
		LOGGER.info("Obtained response  from Gateway: " + responseMsg);
		LOGGER.info("Leaving");
		return responseMsg;
	}
	
}
