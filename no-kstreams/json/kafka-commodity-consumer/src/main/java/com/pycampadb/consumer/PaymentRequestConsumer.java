package com.pycampadb.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.benmanes.caffeine.cache.Cache;
import com.pycampadb.entity.PaymentRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;

//@Service
public class PaymentRequestConsumer {
    private static final Logger log = LoggerFactory.getLogger(PaymentRequestConsumer.class);
    private final ObjectMapper mapper;
    private final Cache<String, Boolean> cachePaymentRequest;

    public PaymentRequestConsumer(
            ObjectMapper mapper,
            @Qualifier("cachePaymentRequest") Cache<String, Boolean> cachePaymentRequest
    ) {
        this.mapper = mapper;
        this.cachePaymentRequest = cachePaymentRequest;
    }

    private boolean isExistsInCache(String key){
        return cachePaymentRequest.getIfPresent(key)!=null;
    }

    @KafkaListener(topics = "t-payment-request")
    public void consumePaymentRequest(String json){
        try{
            var paymentRequest = mapper.readValue(json, PaymentRequest.class);
            var cacheKey = paymentRequest.calculateHash();
            if (isExistsInCache(cacheKey)){
                log.warn("Purchase request is already exists in cache: {}", paymentRequest);
                return;
            }
            log.info("Processing purchase request: {}", paymentRequest);
            cachePaymentRequest.put(cacheKey, true);
        } catch (Exception e) {
            log.error("Error processing purchase request", e);
        }
    }
}
