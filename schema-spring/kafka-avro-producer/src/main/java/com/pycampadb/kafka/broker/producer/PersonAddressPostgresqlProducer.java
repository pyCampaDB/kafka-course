package com.pycampadb.kafka.broker.producer;

import com.course.avro.data.PersonAddressPostgresql;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PersonAddressPostgresqlProducer {
    private final KafkaTemplate<String, PersonAddressPostgresql> kafkaTemplate;

    public PersonAddressPostgresqlProducer(KafkaTemplate<String, PersonAddressPostgresql> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(PersonAddressPostgresql data){
        kafkaTemplate.send("sc-person-address-postgresql", data);
    }
}
