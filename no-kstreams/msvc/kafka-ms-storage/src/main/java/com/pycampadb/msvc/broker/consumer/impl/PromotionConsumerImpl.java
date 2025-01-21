package com.pycampadb.msvc.broker.consumer.impl;

import com.pycampadb.msvc.broker.consumer.PromotionConsumer;
import com.pycampadb.msvc.broker.message.DiscountMessage;
import com.pycampadb.msvc.broker.message.PromotionMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@KafkaListener(topics = "t-commodity-promotion")
public class PromotionConsumerImpl implements PromotionConsumer {
    private static final Logger log = LoggerFactory.getLogger(PromotionConsumerImpl.class);

    @KafkaHandler
    @Override
    public void listenPromotion(PromotionMessage message) {
        log.info("Processing promotion: {}", message);
    }

    @KafkaHandler
    @Override
    public void listenDiscount(DiscountMessage message) {
        log.info("Processing discount: {}", message);
    }
}
