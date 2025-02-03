package com.pycampadb.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableKafkaStreams
@EnableScheduling
public class KafkaUiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaUiDemoApplication.class, args);
	}

}
