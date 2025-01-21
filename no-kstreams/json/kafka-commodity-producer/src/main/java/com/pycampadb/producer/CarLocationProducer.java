package com.pycampadb.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pycampadb.entity.CarLocation;
import org.springframework.kafka.core.KafkaTemplate;

//@Service pasamos a PurchaseRequestProducer
public class CarLocationProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper mapper;
    public CarLocationProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper mapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.mapper = mapper;
    }

    public void sendMessage(CarLocation carLocation){
        try{
            var json = mapper.writeValueAsString(carLocation);
            kafkaTemplate.send("t-location", carLocation.getId(), json);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
