package org.pk.kakfa.kafkaproducer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Value("${spring.kafka.topic-name}")
    private String topicName;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/push/message/{message}")
    public String pushMessage(@PathVariable("message") String message) {
        ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send(topicName, message);
        result.addCallback(new MessageListener());
        return "Message pushed successfully";
    }
}

class MessageListener implements ListenableFutureCallback {
    private static final Logger LOGGER = LogManager.getLogger(MessageListener.class);

    @Override
    public void onFailure(Throwable ex) {
        LOGGER.error("something went wrong while sending message");
        ex.printStackTrace();
        LOGGER.error(ex.getMessage());
    }

    @Override
    public void onSuccess(Object result) {
        LOGGER.info("Message sent successfully with result " + result);
    }
}


