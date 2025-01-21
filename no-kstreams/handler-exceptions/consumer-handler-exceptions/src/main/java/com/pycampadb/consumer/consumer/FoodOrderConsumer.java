package com.pycampadb.consumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pycampadb.consumer.entity.FoodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class FoodOrderConsumer {
    private static final Logger log = LoggerFactory.getLogger(FoodOrderConsumer.class);
    private final ObjectMapper objectMapper;
    private static final int MAX_AMOUNT_ORDER = 7;

    public FoodOrderConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "t-food-order", errorHandler = "myFoodOrderErrorHandler")
    public void consume (String message) {
        try{
            var foodOrder = objectMapper.readValue(message, FoodOrder.class);
            if (foodOrder.getAmount() > MAX_AMOUNT_ORDER){
                log.error("Amount {} exceeds the maximum allowed amount of {}", foodOrder.getAmount(), MAX_AMOUNT_ORDER);
                throw new IllegalArgumentException("Order amount exceeds the maximum limit");
            }
            log.info("Consumed food order: {}", foodOrder);
        } catch (JsonProcessingException e){
            throw new IllegalArgumentException("Algo falla con el mapper");
        }

    }
}
