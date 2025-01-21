package com.pycampadb.consumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pycampadb.consumer.entity.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.retrytopic.TopicSuffixingStrategy;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

@Service
public class Image2Consumer {
    private static final Logger log = LoggerFactory.getLogger(Image2Consumer.class);
    private final ObjectMapper mapper;

    public Image2Consumer(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @RetryableTopic(
            autoCreateTopics = "true",
            attempts = "4",
            topicSuffixingStrategy = TopicSuffixingStrategy.SUFFIX_WITH_INDEX_VALUE,
            backoff = @Backoff(
                    delay = 3000,
                    maxDelay = 10000,
                    multiplier = 1.5,
                    random = true
            ),
            dltTopicSuffix = "-dead"
    )
    @KafkaListener(topics = "t-image-2", concurrency = "2")
    public void consume (String message, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) throws JsonProcessingException {
        var image = mapper.readValue(message, Image.class);
        if ("svg".equalsIgnoreCase(image.getType())) {
            log.warn("Image type is SVG: {}", image);
            throw new IllegalArgumentException("SVG images are not allowed");
        }
        log.info("Consumed message: {} from partition: {}", message, partition);
    }
}
