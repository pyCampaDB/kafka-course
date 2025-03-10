package com.pycampadb.ui.broker.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pycampadb.ui.broker.message.PersonMessage;
import net.datafaker.Faker;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;

@Service
public class KafkaUiDummyProducer {
    private static final String TOPIC_ONE = "t-ui-demo-one";
    private static final String TOPIC_TWO = "t-ui-demo-two";

    private final ObjectMapper mapper;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private Faker faker = new Faker();

    public KafkaUiDummyProducer(ObjectMapper mapper, KafkaTemplate<String, String> kafkaTemplate) {
        this.mapper = mapper;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedDelay = 2000)
    public void publishOne() {
        var now = LocalTime.now();
        var headers = new ArrayList<Header>();

        headers.add(new RecordHeader("Header key 1", Integer.toString(faker.random().nextInt(999999)).getBytes()));
        headers.add(new RecordHeader("Header key 2", Boolean.toString(faker.random().nextBoolean()).getBytes()));

        var producerRecord = new ProducerRecord<String,String>(
                TOPIC_ONE,
                null,
                "This key generated at " + now,
                "This dummy message value generated at " + now + " with boolean " + faker.random().nextBoolean(),
                headers
        );

        kafkaTemplate.send(producerRecord);
    }

    @Scheduled(fixedDelay = 2000)
    public void publishTwo() throws JsonProcessingException {
        var headers = new ArrayList<Header>();

        headers.add(new RecordHeader("country", faker.address().country().getBytes()));
        headers.add(new RecordHeader("version", faker.app().version().getBytes()));

        var person = new PersonMessage(faker.naruto().character(), faker.address().fullAddress());

        var producerRecord = new ProducerRecord<String, String>(
                TOPIC_TWO,
                null,
                "Random IP: "+ faker.internet().ipV4Address(),
                mapper.writeValueAsString(person),
                headers
        );

        kafkaTemplate.send(producerRecord);
    }
}
