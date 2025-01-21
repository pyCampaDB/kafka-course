package com.pycampadb.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class HelloKafkaConsumer {
    private static final Logger log = LoggerFactory.getLogger(HelloKafkaConsumer.class);

    @KafkaListener(topics = "t-hello")
    public void consume(String message){
        log.info("{}", message);
    }
}
