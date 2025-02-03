package com.pycampadb.kafka.scheduler;

import com.pycampadb.kafka.broker.message.personaddress.AddressMessage;
import com.pycampadb.kafka.broker.message.personaddress.PersonMessage;
import com.pycampadb.kafka.broker.producer.PersonProducer;
import net.datafaker.Faker;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PersonAddressScheduler {
    private final Faker faker = new Faker();
    private final PersonProducer producer;

    public PersonAddressScheduler(PersonProducer producer) {
        this.producer = producer;
    }

    @Scheduled(fixedRate = 5000)
    public void publishDummyPerson(){
        producer.publish(fakePerson());
    }

    private AddressMessage fakeAddress(){
        var address = new AddressMessage();

        address.setAddress(faker.address().fullAddress());
        address.setPostalCode(faker.address().zipCode());
        address.setCity(faker.address().city());
        address.setAddressId(faker.number().numberBetween(1, 90_000));

        return address;
    }

    private PersonMessage fakePerson(){
        var person = new PersonMessage();
        var addresses = new ArrayList<AddressMessage>();
        person.setPersonId(faker.number().numberBetween(1, 90_000));
        person.setAddresses(addresses);
        person.setEmail(faker.internet().emailAddress());
        person.setFullName(faker.name().fullName());

        for (int i=0; i < ThreadLocalRandom.current().nextInt(4); i++){
            addresses.add(fakeAddress());
        }

        return person;
    }
}
