package com.pycampadb.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pycampadb.entity.PaymentRequest;
import org.springframework.kafka.core.KafkaTemplate;

//@Service a por el FoodOrder
public class PaymentRequestProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper mapper;

    public PaymentRequestProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper mapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.mapper = mapper;
    }

    public void sendPaymentRequest(PaymentRequest paymentRequest){
        try{
            var json = mapper.writeValueAsString(paymentRequest);
            kafkaTemplate.send("t-payment-request", json);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
