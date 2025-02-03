package com.pycampadb.kafka.broker.producer.impl;

import com.pycampadb.kafka.broker.message.*;
import com.pycampadb.kafka.broker.producer.BasicDataProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BasicDataProducerImpl implements BasicDataProducer {
    private static final String BASE_TOPIC = "t-ksql-basic-data-";
    private final KafkaTemplate<Object, Object> kafkaTemplate;

    public BasicDataProducerImpl(KafkaTemplate<Object, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendBasicDataCountry(BasicDataCountryMessage message) {
        kafkaTemplate.send(BASE_TOPIC+"country", message);
    }

    @Override
    public void sendBasicDataCountryWithNullValue(String countryName) {
        kafkaTemplate.send(BASE_TOPIC + "country", countryName, null);
        kafkaTemplate.send("tbl-basic-data-country", countryName, null);
    }

    @Override
    public void sendBasicDataFive(BasicDataFiveMessage message) {
        kafkaTemplate.send(BASE_TOPIC + "five", message);
    }

    @Override
    public void sendBasicDataFour(BasicDataFourMessage message) {
        kafkaTemplate.send(BASE_TOPIC + "four", message);
    }

    @Override
    public void sendBasicDataOne(BasicDataOneMessage message) {
        kafkaTemplate.send(BASE_TOPIC+"one", message);
    }

    @Override
    public void sendBasicDataPerson(BasicDataPersonMessage message) {
        kafkaTemplate.send(BASE_TOPIC + "person", message);
    }

    @Override
    public void sendBasicDataThree(BasicDataThreeMessage message) {
        kafkaTemplate.send(BASE_TOPIC+"three", message);
    }

    @Override
    public void sendBasicDataTwo(BasicDataTwoMessage message) {
        kafkaTemplate.send(BASE_TOPIC + "two", message);
    }
}
