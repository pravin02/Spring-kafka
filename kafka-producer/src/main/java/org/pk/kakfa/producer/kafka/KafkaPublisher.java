package org.pk.kakfa.producer.kafka;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class KafkaPublisher {

    private static final Logger LOGGER = LogManager.getLogger(KafkaPublisher.class);

    private final KafkaTemplate<String, Object> template;
    @Value("${spring.kafka.topic-name}")
    private String topicName;

    public KafkaPublisher(KafkaTemplate<String, Object> template) {
        this.template = template;
    }


    public void send(@NonNull Object obj) {
        LOGGER.info("Configured topic is {}", topicName);
        CompletableFuture<SendResult<String, Object>> future = template.send(topicName, obj.toString());
        future.whenComplete((stringObjectSendResult, throwable) -> {
            if (null == throwable) {
                LOGGER.info("Object: {}", obj);
                LOGGER.info("Object posted successfully");
            } else {
                LOGGER.error("Failed to post Object", throwable);
            }
        });

    }

}
