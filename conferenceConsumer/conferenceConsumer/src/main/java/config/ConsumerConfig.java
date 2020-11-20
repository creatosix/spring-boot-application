package config;

import java.util.Arrays;
import java.util.Properties;

import com.example.conferenceConsumer.models.Speaker;
import com.example.conferenceConsumer.models.SpeakerRepository;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.beans.factory.annotation.Autowired;


public class ConsumerConfig {
    SpeakerRepository speakerRepository;

    Properties props = new Properties();
    String topicName = "quickstart-events";

    public ConsumerConfig() {
        props.setProperty("bootstrap.servers", "localhost:9092");
        props.setProperty("group.id", "test");
        props.setProperty("enable.auto.commit", "true");
        props.setProperty("auto.commit.interval.ms", "1000");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

    }

    public void receive() {
        Speaker speaker = new Speaker();
        speaker.setLastName(firstName);
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList(topicName));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                speakerRepository.save(new Speaker(record.value));
        }
    }
}