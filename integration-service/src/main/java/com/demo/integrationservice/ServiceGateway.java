package com.demo.integrationservice;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface ServiceGateway {

	@Gateway(requestChannel = "get.request.channel", replyChannel = "reply.channel")
	String getCustomMessage();

}