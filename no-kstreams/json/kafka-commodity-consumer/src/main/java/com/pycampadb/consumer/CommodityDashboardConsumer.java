package com.pycampadb.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pycampadb.entity.Commodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

// @Service ahora vamos a usar CounterConsumer, no Commodity
public class CommodityDashboardConsumer {
    private static final Logger log = LoggerFactory.getLogger(CommodityDashboardConsumer.class);
    private final ObjectMapper mapper;

    public CommodityDashboardConsumer(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @KafkaListener(topics = "t-commodity", groupId = "consumer-group-dashboard")
    public void listen(String message) throws InterruptedException {
        try{
            Commodity commodity = mapper.readValue(message, Commodity.class);
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(5, 10));
            log.info("Dashboard consumer: {}", commodity);
        } catch (JsonMappingException e) {
            log.error("JsonMappingException: {}", e.getMessage(), e);
        } catch (JsonProcessingException e) {
            log.error("JsonProcessingException: {}", e.getMessage(), e);
        }
    }

}
