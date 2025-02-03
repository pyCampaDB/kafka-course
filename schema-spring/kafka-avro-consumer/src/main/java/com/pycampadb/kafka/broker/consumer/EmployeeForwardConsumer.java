package com.pycampadb.kafka.broker.consumer;

import com.pycampadb.avro.data.EmployeeForward;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

//@Service
public class EmployeeForwardConsumer {
    private static final Logger log = LoggerFactory.getLogger(EmployeeForwardConsumer.class);

    @KafkaListener(topics = "sc-employee-forward")
    public void listen(ConsumerRecord<String, EmployeeForward> consumerRecord){
        log.info("{} : {}", consumerRecord.key(), consumerRecord.value());
    }
}
