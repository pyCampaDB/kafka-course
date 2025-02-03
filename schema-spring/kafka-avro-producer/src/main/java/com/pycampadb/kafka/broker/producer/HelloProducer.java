package com.pycampadb.kafka.broker.producer;

import com.pycampadb.avro.data.Hello;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class HelloProducer {
    private final KafkaTemplate<String, Hello> kafkaTemplate;

    public HelloProducer(KafkaTemplate<String, Hello> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Hello data){
        kafkaTemplate.send("sc-hello", data);
    }
}
