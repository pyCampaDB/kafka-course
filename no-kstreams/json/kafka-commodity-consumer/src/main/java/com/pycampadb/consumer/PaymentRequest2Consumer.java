package com.pycampadb.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.benmanes.caffeine.cache.Cache;
import com.pycampadb.entity.PaymentRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;

//@Service toca FoodOrder
public class PaymentRequest2Consumer {
    private static final Logger log = LoggerFactory.getLogger(PaymentRequest2Consumer.class);
    private final ObjectMapper mapper;
    private final Cache<String, Boolean> cachePaymentRequest;

    public PaymentRequest2Consumer(
            ObjectMapper mapper,
            @Qualifier("cachePaymentRequest") Cache<String, Boolean> cachePaymentRequest
    ) {
        this.mapper = mapper;
        this.cachePaymentRequest = cachePaymentRequest;
    }


    @KafkaListener(topics = "t-payment-request", containerFactory = "paymentRequestContainerFactory")
    public void consumePaymentRequest(String json){
        try{
            var paymentRequest = mapper.readValue(json, PaymentRequest.class);
            var cacheKey = paymentRequest.calculateHash();

            log.info("Processing purchase request: {}", paymentRequest);
            cachePaymentRequest.put(cacheKey, true);
        } catch (Exception e) {
            log.error("Error processing purchase request", e);
        }
    }
}
