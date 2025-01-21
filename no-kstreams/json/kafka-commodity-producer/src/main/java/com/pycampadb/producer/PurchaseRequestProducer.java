package com.pycampadb.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pycampadb.entity.PurchaseRequest;
import org.springframework.kafka.core.KafkaTemplate;

//@Service PaymentRequestProducer
public class PurchaseRequestProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper mapper;

    public PurchaseRequestProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper mapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.mapper = mapper;
    }

    public void sendPurchaseRequest(PurchaseRequest purchaseRequest){
        try{
            var json = mapper.writeValueAsString(purchaseRequest);
            kafkaTemplate.send("t-purchase-request", purchaseRequest.getRequestNumber(), json);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
