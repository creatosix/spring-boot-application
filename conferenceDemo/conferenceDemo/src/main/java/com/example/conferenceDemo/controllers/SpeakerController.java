package com.example.conferenceDemo.controllers;

import com.example.conferenceDemo.models.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public void postMessage(@RequestBody final Speaker speaker) {
        kafkaTemplate.send("quickstart-events", speaker);
    }
}

    /*add to consumer program
    @GetMapping
    public List<Speaker> list() {
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id) {
        return speakerRepository.getOne(id);
    }*/

