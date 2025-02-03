package com.pycampadb.kafka.scheduler;

import com.pycampadb.avro.data.EmployeeForward;
import com.pycampadb.kafka.broker.producer.EmployeeForwardProducer;
import net.datafaker.Faker;
import org.springframework.scheduling.annotation.Scheduled;


//@Service
public class EmployeeForwardScheduler {
    private final EmployeeForwardProducer producer;
    private final Faker faker = new Faker();

    public EmployeeForwardScheduler(EmployeeForwardProducer producer) {
        this.producer = producer;
    }

    @Scheduled(fixedRate = 1000)
    public void publishSchedule(){
        var data = EmployeeForward.newBuilder()
                .setFirstName(faker.dragonBall().character())
                .setLastName(faker.naruto().character())
                .setEmail(faker.internet().safeEmailAddress())
                .build();

        producer.send(data);
    }
}
