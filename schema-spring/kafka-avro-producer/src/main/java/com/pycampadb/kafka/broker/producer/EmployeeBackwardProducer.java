package com.pycampadb.kafka.broker.producer;

import com.pycampadb.avro.data.EmployeeBackward;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeBackwardProducer {
    private final KafkaTemplate<String, EmployeeBackward> kafkaTemplate;

    public EmployeeBackwardProducer(KafkaTemplate<String, EmployeeBackward> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(EmployeeBackward data){
        kafkaTemplate.send("sc-employee-backward", data);
    }
}
