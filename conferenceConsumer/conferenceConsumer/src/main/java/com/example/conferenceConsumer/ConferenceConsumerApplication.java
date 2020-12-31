package com.example.conferenceConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class ConferenceConsumerApplication {
	@Autowired
	ConsumerConfig consumerConfig;

	public static void main(String[] args) {
		SpringApplication.run(ConferenceConsumerApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		consumerConfig.receive();
	}
}
