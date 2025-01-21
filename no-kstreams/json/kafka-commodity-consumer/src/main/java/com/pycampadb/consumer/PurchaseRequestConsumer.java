package com.pycampadb.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.benmanes.caffeine.cache.Cache;
import com.pycampadb.entity.PurchaseRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;

//@Service PaymentRequest
public class PurchaseRequestConsumer {
    private static final Logger log = LoggerFactory.getLogger(PurchaseRequestConsumer.class);
    private final ObjectMapper mapper;
    private final Cache<String, Boolean> cachePurchaseRequest;

    public PurchaseRequestConsumer(
            ObjectMapper mapper,
            @Qualifier("cachePurchaseRequest") Cache<String, Boolean> cachePurchaseRequest
    ) {
        this.mapper = mapper;
        this.cachePurchaseRequest = cachePurchaseRequest;
    }

    private boolean isExistsInCache(String requestNumber){
        return cachePurchaseRequest.getIfPresent(requestNumber)!=null;
    }

    @KafkaListener(topics = "t-purchase-request")
    public void consumePurchaseRequest(String json){
        try{
            var purchaseRequest = mapper.readValue(json, PurchaseRequest.class);
            if (isExistsInCache(purchaseRequest.getRequestNumber())){
                log.warn("Purchase request is already exists in cache: {}", purchaseRequest.getRequestNumber());
                return;
            }
            log.info("Processing purchase request: {}", purchaseRequest.getRequestNumber());
            cachePurchaseRequest.put(purchaseRequest.getRequestNumber(), true);
        } catch (Exception e) {
            log.error("Error processing purchase request", e);
        }
    }
}
