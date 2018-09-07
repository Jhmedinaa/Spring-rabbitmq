package com.amqp.models.entity;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Ping {

	@Autowired
	private AmqpTemplate template;
	
	@Value("${jsa.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${jsa.rabbitmq.routingkey}")
	private String routingKey;
	
	
	@Scheduled(fixedDelay = 5000, initialDelay = 1000)
	public String enviar(String message) {

		System.out.println("mensaje  -->" + message);
		//template.convertAndSend(exchange, routingKey, message);
		String respuesta = (String) template.convertSendAndReceive
				(exchange, routingKey, message);
		System.out.println("respuesta ---> " + respuesta);
		return respuesta;
		//return "ji";
	}
}
