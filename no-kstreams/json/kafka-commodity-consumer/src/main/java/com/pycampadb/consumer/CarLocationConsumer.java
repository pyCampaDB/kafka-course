package com.pycampadb.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pycampadb.entity.CarLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

//@Service PurchaseRequest lo sustituye
public class CarLocationConsumer {
    private static final Logger log = LoggerFactory.getLogger(CarLocationConsumer.class);

    private final ObjectMapper mapper;

    public CarLocationConsumer(ObjectMapper mapper) {
        this.mapper = mapper;
    }
    @KafkaListener(topics = "t-location", groupId = "group-location-all")
    public void listenAll(String message) throws JsonProcessingException {
        var carLocation = mapper.readValue(message, CarLocation.class);
        log.info("listenAll: {}", carLocation);
    }
    @KafkaListener(topics = "t-location", groupId = "group-location-far", containerFactory = "locationFarContainerFactory")
    public void listenFar (String message) throws JsonProcessingException {
        var carLocation = mapper.readValue(message, CarLocation.class);
        log.info("listenFar: {}", carLocation);
    }
}
