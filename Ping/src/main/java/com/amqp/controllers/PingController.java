package com.amqp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amqp.models.entity.Ping;

@RestController
public class PingController {
	
	@Autowired
	private Ping ping;
	
	@GetMapping("/ping/{mensaje}")
	public String mensajePing(@PathVariable String mensaje) {
		return ping.enviar(mensaje);
	}
}
