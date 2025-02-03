package com.pycampadb.kafka.scheduler;

import com.course.avro.data.PersonAddressPostgresql;
import com.pycampadb.kafka.broker.producer.PersonAddressPostgresqlProducer;
import net.datafaker.Faker;
import org.springframework.scheduling.annotation.Scheduled;

//@Service
public class PersonAddressPostgresqlScheduler {
    private Faker faker = new Faker();

    private final PersonAddressPostgresqlProducer producer;

    public PersonAddressPostgresqlScheduler(PersonAddressPostgresqlProducer producer) {
        this.producer = producer;
    }

    @Scheduled(fixedRate = 1000)
    public void generatePersonAddress(){
        var personAddress = fakePersonAddress();
        producer.publish(personAddress);
    }


    private PersonAddressPostgresql fakePersonAddress(){
        var result = new PersonAddressPostgresql();

        result.setFullName(faker.naruto().character());
        result.setAddress(faker.address().streetAddress());
        result.setCity(faker.address().cityName());
        result.setPostalCode(faker.address().zipCode());

        return result;
    }
}
