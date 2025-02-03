package com.pycampadb.kafka.config;

import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.Map;

@Configuration
public class KafkaStreamConfig {
    private static final String SCHEMA_REGISTRY_URL = "http://localhost:8081";

    @Bean("serdeConfig")
    Map<String, String> serdeConfig(){
        return Collections.singletonMap(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, SCHEMA_REGISTRY_URL);
    }
}
