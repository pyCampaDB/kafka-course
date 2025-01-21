package com.pycampadb.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pycampadb.entity.Commodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service

//@Service comentado para que no interfiera con CounterConsumer
public class CommodityNotificationConsumer {
    private static final Logger log = LoggerFactory.getLogger(CommodityNotificationConsumer.class);
    private final ObjectMapper mapper;

    public CommodityNotificationConsumer(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @KafkaListener(topics = "t-commodity", groupId = "consumer-group-notification")
    public void listen(String message){
        try{
            Commodity commodity = mapper.readValue(message, Commodity.class);
            log.info("Notification consumer: {}", commodity);
        } catch (JsonMappingException e) {
            log.error("JsonMappingException: {}", e.getMessage(), e);
        } catch (JsonProcessingException e) {
            log.error("JsonProcessingException: {}", e.getMessage(), e);
        }
    }

}
