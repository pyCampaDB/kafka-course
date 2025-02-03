package com.pycampadb.kafka.scheduler;

import com.pycampadb.avro.data.Hello;
import com.pycampadb.kafka.broker.producer.HelloProducer;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

//@Service
public class HelloScheduler {
    private final HelloProducer producer;

    public HelloScheduler(HelloProducer producer) {
        this.producer = producer;
    }

    @Scheduled(fixedRate = 1000)
    public void publishSchedule(){
        var data = Hello.newBuilder()
                .setMyIntField(ThreadLocalRandom.current().nextInt())
                .setMyStringField("Now is " + LocalTime.now())
                .build();

        producer.send(data);
    }
}
