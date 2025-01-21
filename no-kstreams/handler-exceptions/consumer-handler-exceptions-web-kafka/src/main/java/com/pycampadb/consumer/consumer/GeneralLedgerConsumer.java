package com.pycampadb.consumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class GeneralLedgerConsumer {
    private static final Logger log = LoggerFactory.getLogger(GeneralLedgerConsumer.class);

    @KafkaListener(topics = "t-general-ledger", id = "consumer-ledger-one")
    public void consumeLedgerOne(String message){
        log.info("consumeLedgerOne() consumed message: {}", message);
    }

    @KafkaListener(topics = "t-general-ledger")
    public void consumeLedgerTwo(String message){
        log.info("consumeLedgerTwo() consumed message: {}", message);
    }
}
