package com.pycampadb.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaKeyProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaKeyProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String key, String message){
        kafkaTemplate.send("t-multi-partitions", key, message);
    }
}
