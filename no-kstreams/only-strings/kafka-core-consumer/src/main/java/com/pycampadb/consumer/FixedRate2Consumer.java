package com.pycampadb.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class FixedRate2Consumer {
    private static final Logger log = LoggerFactory.getLogger(FixedRate2Consumer.class);
    private final String topic = "t-fixedrate-2";
    @KafkaListener(topics = topic)
    public void consume(String message){
        log.info("Consuming message: {} of the topic {}", message, topic);
    }
}
