package com.example.conferenceConsumer;

import config.ConsumerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConferenceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConferenceConsumerApplication.class, args);
		ConsumerConfig consumerConfig = new ConsumerConfig();
		consumerConfig.receive();

	}

}
