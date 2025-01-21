package com.pycampadb.msvc.config;

import org.springframework.kafka.config.KafkaStreamsConfiguration;

public interface KafkaStreamConfig {
    KafkaStreamsConfiguration kafkaStreamsConfiguration();
}
