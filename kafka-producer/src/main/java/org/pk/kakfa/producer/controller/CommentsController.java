package org.pk.kakfa.producer.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pk.kakfa.producer.kafka.KafkaPublisher;
import org.pk.kakfa.producer.model.Comment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class CommentsController {

    private static final Logger LOGGER = LogManager.getLogger(CommentsController.class);

    private final KafkaPublisher kafkaPublisher;

    public CommentsController(KafkaPublisher kafkaPublisher) {
        this.kafkaPublisher = kafkaPublisher;
    }

    @PostMapping
    public void postComment(@RequestBody Comment comment) {
        LOGGER.info("Posted Comment {}", comment);
        for (int i = 0; i < 100000; i++) {
            comment.setCommentId(i + 1);
            kafkaPublisher.send(comment);
        }
    }

}
