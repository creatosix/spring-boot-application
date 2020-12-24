package com.example.conferenceDemo.controllers;

import com.example.conferenceDemo.models.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {
    @Autowired
    KafkaTemplate<String, Speaker> kafkaTemplate;

    @RequestMapping(consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public void postMessage(Speaker speaker) {
        kafkaTemplate.send("quickstart-events", speaker);
    }
}
