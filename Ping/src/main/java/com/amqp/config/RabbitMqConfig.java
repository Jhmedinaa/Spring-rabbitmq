package com.amqp.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.amqp.models.entity.Ping;

@Configuration
public class RabbitMqConfig {
	
	@Profile("ping")
	private static class PingConfig{
		
		@Bean
		public DirectExchange exchange() {
			return new DirectExchange("rpc");
		}
		
		@Bean
		public Ping ping() {
			return new Ping();					
		}
	}
	
	
	
}
