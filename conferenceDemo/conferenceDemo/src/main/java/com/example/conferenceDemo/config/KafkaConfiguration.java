package com.example.conferenceDemo.config;

import com.example.conferenceDemo.models.Speaker;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;


import java.util.HashMap;
import java.util.Map;
import static org.apache.kafka.common.security.auth.SecurityProtocol.PLAINTEXT;

@Configuration
public class KafkaConfiguration {
    public ProducerFactory<String, Speaker> producerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put("bootstrap.servers", "localhost:9092");
        config.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

       /* config.put("value.serializer",
        "org.apache.kafka.common.serialization.JsonSerializer");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);*/
        return new DefaultKafkaProducerFactory<>(config);
        
    }
    @Bean
    KafkaTemplate<String, Speaker> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
