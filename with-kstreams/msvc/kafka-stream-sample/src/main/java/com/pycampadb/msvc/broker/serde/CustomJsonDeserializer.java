package com.pycampadb.msvc.broker.serde;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.kafka.support.serializer.DeserializationException;

import java.io.IOException;

public class CustomJsonDeserializer<T> implements Deserializer<T> {
    private final ObjectMapper mapper;

    private final Class<T> deserializedClass;

    public CustomJsonDeserializer(ObjectMapper mapper, Class<T> deserializedClass) {
        this.mapper = mapper;
        this.deserializedClass = deserializedClass;
    }

    @Override
    public T deserialize(String topic, byte[] data) {
        try {
            return mapper.readValue(data, deserializedClass);
        } catch (IOException e) {
            throw new DeserializationException("Error deserializing the data", data, false, e.getCause());
        }
    }
}
