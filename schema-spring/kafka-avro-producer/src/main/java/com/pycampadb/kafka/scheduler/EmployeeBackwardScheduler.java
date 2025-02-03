package com.pycampadb.kafka.scheduler;

import com.pycampadb.avro.data.EmployeeBackward;
import com.pycampadb.kafka.broker.producer.EmployeeBackwardProducer;
import net.datafaker.Faker;
import org.springframework.scheduling.annotation.Scheduled;


//@Service
public class EmployeeBackwardScheduler {
    private final EmployeeBackwardProducer producer;
    private final Faker faker = new Faker();

    public EmployeeBackwardScheduler(EmployeeBackwardProducer producer) {
        this.producer = producer;
    }

    @Scheduled(fixedRate = 1000)
    public void publishSchedule(){
        var data = EmployeeBackward.newBuilder()
                .setFirstName(faker.dragonBall().character())
                .setLastName(faker.naruto().character())
                .build();

        producer.send(data);
    }
}
