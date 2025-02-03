package com.pycampadb.kafka.broker.producer;

import com.pycampadb.avro.data.Avro01;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Avro01Producer {
    private final KafkaTemplate<String, Avro01> kafkaTemplate;


    public Avro01Producer(KafkaTemplate<String, Avro01> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send (Avro01 message){
        kafkaTemplate.send("sc-avro01", message);
    }
}
