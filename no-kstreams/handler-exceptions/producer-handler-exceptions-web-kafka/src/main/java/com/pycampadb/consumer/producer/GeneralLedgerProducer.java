package com.pycampadb.consumer.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class GeneralLedgerProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public GeneralLedgerProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendGeneralLedgerMessage (String message){
        kafkaTemplate.send("t-general-ledger", message);
    }
}
