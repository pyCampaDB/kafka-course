package com.pycampadb.consumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pycampadb.consumer.entity.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class ImageConsumer {
    private static final Logger log = LoggerFactory.getLogger(ImageConsumer.class);
    private final ObjectMapper mapper;

    public ImageConsumer(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @KafkaListener(topics = "t-image", concurrency = "2", containerFactory = "imageRetryContainerFactory")
    public void consume (String message, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) throws JsonProcessingException {
        var image = mapper.readValue(message, Image.class);
        if ("svg".equalsIgnoreCase(image.getType()))
            throw new IllegalArgumentException("SVG images are not allowed");
        log.info("Consumed message: {} from partition: {}", message, partition);
    }
}
