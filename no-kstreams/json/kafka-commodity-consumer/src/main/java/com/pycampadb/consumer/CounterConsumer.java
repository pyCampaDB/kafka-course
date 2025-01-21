package com.pycampadb.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service

import java.util.concurrent.TimeUnit;
//@Service vamos a utilizar RebalanceConsumer
public class CounterConsumer {
    private static final Logger log = LoggerFactory.getLogger(CounterConsumer.class);

    @KafkaListener(topics = "t-counter", groupId = "counter-group-fast")
    public void consumeFast(String message){
        log.info("Fast: {}", message);
    }

    @KafkaListener(topics = "t-counter", groupId = "counter-group-slow")
    public void consumeSlow(String message) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        log.info("Slow: {}", message);
    }
}
