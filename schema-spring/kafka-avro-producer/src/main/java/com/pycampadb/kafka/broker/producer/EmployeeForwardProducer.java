package com.pycampadb.kafka.broker.producer;

import com.pycampadb.avro.data.EmployeeForward;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeForwardProducer {
    private final KafkaTemplate<String, EmployeeForward> kafkaTemplate;

    public EmployeeForwardProducer(KafkaTemplate<String, EmployeeForward> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(EmployeeForward data){
        kafkaTemplate.send("sc-employee-forward", data);
    }
}
