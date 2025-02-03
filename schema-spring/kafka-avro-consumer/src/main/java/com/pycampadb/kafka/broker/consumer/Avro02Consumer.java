package com.pycampadb.kafka.broker.consumer;

import com.pycampadb.avro.data.Avro02;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

//@Service
public class Avro02Consumer {
    private static final Logger log = LoggerFactory.getLogger(Avro02Consumer.class);

    @KafkaListener(topics = "sc-avro02")
    public void listen(ConsumerRecord<String, Avro02> consumerRecord){
        log.info("{} : {}", consumerRecord.key(), consumerRecord.value());
    }
}
