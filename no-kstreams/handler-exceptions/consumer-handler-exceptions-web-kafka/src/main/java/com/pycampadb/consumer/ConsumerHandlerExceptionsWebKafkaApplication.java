package com.pycampadb.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ConsumerHandlerExceptionsWebKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerHandlerExceptionsWebKafkaApplication.class, args);
	}

}
