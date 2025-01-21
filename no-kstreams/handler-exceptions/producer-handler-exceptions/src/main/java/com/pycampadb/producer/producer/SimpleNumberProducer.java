package com.pycampadb.producer.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pycampadb.producer.entity.SimpleNumber;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SimpleNumberProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper mapper;

    public SimpleNumberProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper mapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.mapper = mapper;
    }

    public void sendSimpleNumber(SimpleNumber simpleNumber){
        try{
            var json = mapper.writeValueAsString(simpleNumber);
            kafkaTemplate.send("t-simple-number", json);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException(e);
        }
    }
}
