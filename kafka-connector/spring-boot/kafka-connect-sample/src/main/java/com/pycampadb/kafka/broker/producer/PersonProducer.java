package com.pycampadb.kafka.broker.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pycampadb.kafka.broker.message.personaddress.PersonMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PersonProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper mapper;

    public PersonProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper mapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.mapper = mapper;
    }

    public void publish (PersonMessage message){
        try{
            var strMessage = mapper.writeValueAsString(message);
            kafkaTemplate.send("t-person-address-custom", strMessage);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
