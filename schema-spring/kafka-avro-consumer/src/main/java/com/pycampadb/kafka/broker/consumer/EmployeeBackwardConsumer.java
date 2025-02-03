package com.pycampadb.kafka.broker.consumer;

import com.pycampadb.avro.data.EmployeeBackward;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

//@Service
public class EmployeeBackwardConsumer {
    private static final Logger log = LoggerFactory.getLogger(EmployeeBackwardConsumer.class);

    @KafkaListener(topics = "sc-employee-backward")
    public void listen(ConsumerRecord<String, EmployeeBackward> consumerRecord){
        log.info("{} : {}", consumerRecord.key(), consumerRecord.value());
    }
}
