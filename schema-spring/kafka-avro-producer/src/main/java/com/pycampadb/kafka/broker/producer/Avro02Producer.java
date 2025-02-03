package com.pycampadb.kafka.broker.producer;

import com.pycampadb.avro.data.Avro02;
import org.springframework.kafka.core.KafkaTemplate;

//@Service
public class Avro02Producer {
    private final KafkaTemplate<String, Avro02> kafkaTemplate;


    public Avro02Producer(KafkaTemplate<String, Avro02> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send (Avro02 message){
        kafkaTemplate.send("sc-avro02", message);
    }
}
