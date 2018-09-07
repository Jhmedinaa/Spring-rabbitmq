package com.amqp.model.controllers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Pong {

	@RabbitListener(queues="${jsa.rabbitmq.queue}")
	public String pong(String mensaje) {
		System.out.println("llego ->" + mensaje);
		mensaje = mensaje.equals("ping")  ? "pong" : "Mensaje No identificado";
		return mensaje;
	}
}
