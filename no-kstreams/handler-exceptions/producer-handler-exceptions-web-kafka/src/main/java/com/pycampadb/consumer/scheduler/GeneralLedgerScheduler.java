package com.pycampadb.consumer.scheduler;

import com.pycampadb.consumer.producer.GeneralLedgerProducer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class GeneralLedgerScheduler {
    private static final AtomicInteger COUNTER = new AtomicInteger();

    private final GeneralLedgerProducer producer;

    public GeneralLedgerScheduler(GeneralLedgerProducer producer) {
        this.producer = producer;
    }

    @Scheduled(fixedRate = 1000)
    public void schedule(){
        producer.sendGeneralLedgerMessage("Message " + COUNTER.incrementAndGet());
    }
}
