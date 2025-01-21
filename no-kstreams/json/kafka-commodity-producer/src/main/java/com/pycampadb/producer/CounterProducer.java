package com.pycampadb.producer;

import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service

//@Service
public class CounterProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public CounterProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessages (int number){
        for (int i=0; i < number; i++){
            var message = "Data " + i;
            kafkaTemplate.send("t-counter", message);
        }
    }
}
