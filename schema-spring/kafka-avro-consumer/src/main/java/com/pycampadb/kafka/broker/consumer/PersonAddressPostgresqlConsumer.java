package com.pycampadb.kafka.broker.consumer;

import com.course.avro.data.PersonAddressPostgresql;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PersonAddressPostgresqlConsumer {

    private static final Logger log = LoggerFactory.getLogger(PersonAddressPostgresqlConsumer.class);

    @KafkaListener(topics = "sc-person-address-postgresql")
    public void listen(ConsumerRecord<String, PersonAddressPostgresql> consumerRecord){
        log.info("Person address: {}", consumerRecord.value());
    }
}
