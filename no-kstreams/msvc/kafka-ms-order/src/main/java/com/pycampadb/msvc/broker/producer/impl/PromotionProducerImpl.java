package com.pycampadb.msvc.broker.producer.impl;

import com.pycampadb.msvc.broker.message.PromotionMessage;
import com.pycampadb.msvc.broker.producer.PromotionProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PromotionProducerImpl implements PromotionProducer {
    private static final Logger log = LoggerFactory.getLogger(PromotionProducerImpl.class);

    private final KafkaTemplate<String, PromotionMessage> kafkaTemplate;

    public PromotionProducerImpl(KafkaTemplate<String, PromotionMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendPromotion(PromotionMessage message) {
        try{
            var sendResult = kafkaTemplate
                    .send("t-commodity-promotion", message.getPromotionCode(), message)
                    .get(3, TimeUnit.SECONDS); //envío síncrono
            log.info("Promotion code: {} sent successfully", sendResult.getProducerRecord().value());
        } catch (Exception e) {
            log.error("Error sending promotion {}", message.getPromotionCode(), e);
        }
        log.info("Just a dummy message for promotion {}", message.getPromotionCode());
    }
}
