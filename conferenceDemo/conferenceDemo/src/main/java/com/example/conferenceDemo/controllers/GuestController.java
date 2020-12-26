package com.example.conferenceDemo.controllers;

import com.example.conferenceDemo.models.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/guest")
public class GuestController {
    @Autowired
    KafkaTemplate<String, Guest> kafkaTemplate;

    @RequestMapping(consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public void postMessage(Guest guest) {
        kafkaTemplate.send("quickstart-events", guest);
    }
}