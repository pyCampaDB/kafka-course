package com.pycampadb.consumer.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class GeneralLedgerScheduler {
    private static final Logger log = LoggerFactory.getLogger(GeneralLedgerScheduler.class);
    private final KafkaListenerEndpointRegistry registry;

    public GeneralLedgerScheduler(KafkaListenerEndpointRegistry registry) {
        this.registry = registry;
    }

    @Scheduled(cron = "0 54 6 * * *") //definimos la pausa
    public void pause(){
        log.info("Pause listener");
        var myRegistry = registry.getListenerContainer("consumer-ledger-one");
        if (myRegistry != null)
            myRegistry.pause();
    }

    @Scheduled(cron = "1 56 6 * * *") //definimos la reanudación
    public void resume(){
        log.info("Resume listener");
        var myRegistry = registry.getListenerContainer("consumer-ledger-one");
        if (myRegistry != null)
            myRegistry.resume();
    }
}
