package com.pycampadb.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.benmanes.caffeine.cache.Cache;
import com.pycampadb.entity.CarLocation;
import com.pycampadb.entity.PaymentRequest;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.ssl.SslBundles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.security.NoSuchAlgorithmException;

@Configuration
public class KafkaConfig {
    private final KafkaProperties kafkaProperties;

    public KafkaConfig(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    //@Bean las comentamos para utilizar los valores por defecto y definidos en application.yml
    ConsumerFactory<Object, Object> consumerFactory(SslBundles sslBundles){
        var properties = kafkaProperties.buildConsumerProperties(sslBundles);
        properties.put(ConsumerConfig.METRICS_SAMPLE_WINDOW_MS_CONFIG, "40000");
        return new DefaultKafkaConsumerFactory<>(properties);
    }

    @Bean(name = "locationFarContainerFactory")
    ConcurrentKafkaListenerContainerFactory<Object, Object> locationFarContainerFactory (
            ConcurrentKafkaListenerContainerFactoryConfigurer configurer,
            SslBundles sslBundles,
            ObjectMapper mapper
    ){
        var factory = new ConcurrentKafkaListenerContainerFactory<Object, Object>();
        configurer.configure(factory, consumerFactory(sslBundles));
        factory.setRecordFilterStrategy(consumerRecord -> {
            try {
                var carLocation = mapper.readValue(consumerRecord.value().toString(), CarLocation.class);
                return carLocation.getDistance() <=100;
            } catch (JsonProcessingException e) {
                return false;
            }
        });
        return factory;
    }

    @Bean(name = "paymentRequestContainerFactory")
    ConcurrentKafkaListenerContainerFactory<Object, Object> paymentRequestContainerFactory(
            ConcurrentKafkaListenerContainerFactoryConfigurer configurer,
            SslBundles sslBundles,
            ObjectMapper mapper,
            @Qualifier("cachePaymentRequest") Cache<String, Boolean> cachePaymentRequest
    ){
        var factory = new ConcurrentKafkaListenerContainerFactory<Object, Object>();
        configurer.configure(factory, consumerFactory(sslBundles));

        factory.setRecordFilterStrategy(consumerRecord -> {
            try {
                var paymentRequest = mapper.readValue(consumerRecord.value().toString(), PaymentRequest.class);
                var cacheKey = paymentRequest.calculateHash();
                return cachePaymentRequest.getIfPresent(cacheKey)!=null;
            } catch (JsonProcessingException | NoSuchAlgorithmException e) {
                return false;
            }
        });
        return factory;
    }
}
