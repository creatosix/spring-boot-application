package com.example.conferenceConsumer;

import java.util.Arrays;
import java.util.Properties;

import com.example.conferenceConsumer.models.Speaker;
import com.example.conferenceConsumer.models.SpeakerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsumerConfig {
    SpeakerRepository speakerRepository;
    Properties props = new Properties();
    String topicName = "quickstart-events";

    @Autowired
    public ConsumerConfig(SpeakerRepository speakerRepository) {
        this.speakerRepository = speakerRepository;
        props.setProperty("bootstrap.servers", "localhost:9092");
        props.setProperty("group.id", "test");
        props.setProperty("enable.auto.commit", "true");
        props.setProperty("auto.commit.interval.ms", "1000");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    }

    public void receive() {
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList(topicName));
        if (speakerRepository == null){
            System.out.println("speaker repository is null");
        } else {
            System.out.println("speaker repository is not null");
        }

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                ObjectMapper mapper = new ObjectMapper();
                try {
                    Speaker speaker = mapper.readValue(record.value(), Speaker.class);
                    speakerRepository.save(speaker);
                    System.out.println(speaker);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}