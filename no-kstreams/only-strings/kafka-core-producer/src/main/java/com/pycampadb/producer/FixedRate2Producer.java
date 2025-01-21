package com.pycampadb.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class FixedRate2Producer {
    private static final Logger log = LoggerFactory.getLogger(FixedRate2Producer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;
    private int i= 0;

    public FixedRate2Producer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedRate = 1000)
    public void sendMessage(){
        i++;
        log.info("Value of i: {}",i);
        kafkaTemplate.send("t-fixedrate-2", "Fixed rate message " + i);
    }
}
