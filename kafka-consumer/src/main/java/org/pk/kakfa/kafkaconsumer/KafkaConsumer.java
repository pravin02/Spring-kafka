package org.pk.kakfa.kafkaconsumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private static final Logger LOGGER = LogManager.getLogger(KafkaConsumerApplication.class);

    @KafkaListener(topics = "test", groupId = "1")
    public void receiveMessage(String message) {
        LOGGER.info("Message: " + message);
    }

}
