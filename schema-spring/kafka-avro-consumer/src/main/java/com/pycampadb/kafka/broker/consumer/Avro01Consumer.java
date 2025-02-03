package com.pycampadb.kafka.broker.consumer;

import com.pycampadb.avro.data.Avro01;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

//@Service
public class Avro01Consumer {
    private static final Logger log = LoggerFactory.getLogger(Avro01Consumer.class);

    @KafkaListener(topics = "sc-avro01")
    public void listen(ConsumerRecord<String, Avro01> consumerRecord){
        log.info("{} : {}", consumerRecord.key(), consumerRecord.value());
    }
}
