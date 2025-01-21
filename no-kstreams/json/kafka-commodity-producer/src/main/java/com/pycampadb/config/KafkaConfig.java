package com.pycampadb.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.ssl.SslBundles;
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

//@Configuration las comentamos para utilizar los valores por defecto y definidos en application.yml
public class KafkaConfig {
    private final KafkaProperties kafkaProperties;

    public KafkaConfig(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    //@Bean
    ProducerFactory<String, String> producerFactory(SslBundles sslBundles){
        var properties = kafkaProperties.buildProducerProperties(sslBundles);
        properties.put(ProducerConfig.METRICS_SAMPLE_WINDOW_MS_CONFIG, "50000");
        return new DefaultKafkaProducerFactory<>(properties);
    }

    //@Bean
    KafkaTemplate<String ,String> kafkaTemplate(SslBundles sslBundles){
        return new KafkaTemplate<>(producerFactory(sslBundles));
    }
}
