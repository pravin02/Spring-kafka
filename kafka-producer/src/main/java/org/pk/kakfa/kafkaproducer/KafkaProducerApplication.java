package org.pk.kakfa.kafkaproducer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@EnableKafka
@SpringBootApplication
public class KafkaProducerApplication {
    private static final Logger LOGGER = LogManager.getLogger(KafkaProducerApplication.class);

    @Value("spring.kafka.topic-name")
    private String topicName;

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }

    @KafkaListener(topics = "test", groupId = "1")
    public void receiveMessage(String message) {
        LOGGER.info("Received Message " + message);
    }

}
