package com.pycampadb.consumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pycampadb.consumer.entity.SimpleNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SimpleNumberConsumer {
    private static final Logger log = LoggerFactory.getLogger(SimpleNumberConsumer.class);
    private final ObjectMapper mapper;


    public SimpleNumberConsumer(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @KafkaListener(topics = "t-simple-number")
    public void consume(String message) throws JsonProcessingException {
        var simpleNumber = mapper.readValue(message, SimpleNumber.class);
        int number = simpleNumber.getNumber();
        if (number%2 != 0){
            throw new IllegalArgumentException("Number is odd: "+ number);
        }
        log.info("Number is even: {}", number);
    }
}
