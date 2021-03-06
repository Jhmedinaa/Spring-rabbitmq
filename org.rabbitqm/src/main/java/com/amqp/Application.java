package com.amqp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Application {

	 @Profile("usage_message")
	    @Bean
	    public CommandLineRunner usage() {
	        return new CommandLineRunner() {

	            @Override
	            public void run(String... arg0) throws Exception {
	                System.out.println("This app uses Spring Profiles to "
	                		+ "control its behavior.\n");
	                
	                System.out.println(" Sample usage: java -jar "
	                		+ " rabbit-tutorials.jar "
	                		+ " --spring.profiles.active=hello-world,sender");
	                System.out.println("java -jar rabbit-tutorials.jar --spring.profiles.active=hello-world,receiver");
					System.out.println("java -jar rabbit-tutorials.jar --spring.profiles.active=hello-world,sender");
					System.out.println("java -jar rabbit-tutorials.jar --spring.profiles.active=work-queues,receiver");

					System.out.println("java -jar rabbit-tutorials.jar --spring.profiles.active=rpc,server");
	            }
	        };
	    }

	    @Profile("!usage_message")
	    @Bean
	    public CommandLineRunner tutorial() {
	        return new RabbitAmqpTutorialsRunner();
	    }
	    
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
