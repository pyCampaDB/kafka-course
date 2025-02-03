package com.pycampadb.kafka.broker.stream.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pycampadb.kafka.broker.message.kafkaconnect.*;
import com.pycampadb.kafka.broker.message.personaddress.AddressMessage;
import com.pycampadb.kafka.broker.message.personaddress.PersonMessage;
import com.pycampadb.kafka.broker.schema.KafkaConnectPersonAddressTargetKeySchema;
import com.pycampadb.kafka.broker.schema.KafkaConnectPersonAddressTargetValueSchema;
import com.pycampadb.kafka.broker.stream.PersonAddressStream;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KeyValueMapper;
import org.apache.kafka.streams.kstream.Produced;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PersonAddressFromCustomStream implements PersonAddressStream {
    public static final String HTTP_TOPIC = "t-person-address-custom";
    public static final String TARGET_TOPIC = "t-person-address-target";
    private static final Logger log = LoggerFactory.getLogger(PersonAddressFromCustomStream.class);
    private final ObjectMapper mapper;

    public PersonAddressFromCustomStream(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    @Autowired
    public void kStreamPersonAddress(StreamsBuilder builder) {
        var sourceStream = builder.stream(HTTP_TOPIC, Consumed.with(Serdes.String(), Serdes.String()));
        var targetStream = sourceStream.flatMap(expandPersonAddress());
        targetStream.to(TARGET_TOPIC, Produced.with(Serdes.String(), Serdes.String()));
    }

    private KeyValueMapper<String, String, Iterable<KeyValue<String, String>>> expandPersonAddress() {
        return (key, value) -> {
            var expanded = new ArrayList<KeyValue<String, String>>();

            try{
                var original = mapper.readValue(value, PersonMessage.class);

                for (var address: original.getAddresses()){
                    var targetKey = generateTargetKey(address.getAddressId());
                    var targetValue = generateTargetValue(original, address);

                    expanded.add(KeyValue.pair(targetKey, targetValue));
                }
            } catch (JsonProcessingException e) {
                log.error("Invalid data : {}, throws : {}", value, e.getMessage());
            }
            return expanded;
        };
    }

    private String generateTargetKey (int addressId) throws JsonProcessingException {
        var targetKey = new KafkaConnectMessage<Integer>();
        targetKey.setSchema(KafkaConnectPersonAddressTargetKeySchema.instance());
        targetKey.setPayload(addressId);
        return mapper.writeValueAsString(targetKey);
    }

    private String generateTargetValue (PersonMessage person, AddressMessage address)
            throws JsonProcessingException {
        var targetPayload = new KafkaConnectPersonTargetMessage();
        targetPayload.setEmail(person.getEmail());
        targetPayload.setPersonId(person.getPersonId());
        targetPayload.setFullName(person.getFullName());
        targetPayload.setAddress(address.getAddress());
        targetPayload.setCity(address.getCity());
        targetPayload.setPostalCode(address.getPostalCode());
        targetPayload.setAddressId(address.getAddressId());

        var targetValue = new KafkaConnectMessage<KafkaConnectPersonTargetMessage>();
        targetValue.setSchema(KafkaConnectPersonAddressTargetValueSchema.instance());
        targetValue.setPayload(targetPayload);

        return mapper.writeValueAsString(targetValue);
    }
}
