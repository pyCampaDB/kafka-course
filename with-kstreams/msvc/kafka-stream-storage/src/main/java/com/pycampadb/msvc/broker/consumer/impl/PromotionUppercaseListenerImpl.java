package com.pycampadb.msvc.broker.consumer.impl;

import com.pycampadb.msvc.broker.consumer.PromotionUppercaseListener;
import com.pycampadb.msvc.broker.message.PromotionMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PromotionUppercaseListenerImpl implements PromotionUppercaseListener {
    private static final Logger log = LoggerFactory.getLogger(PromotionUppercaseListenerImpl.class);

    @Override
    @KafkaListener(topics = "t-commodity-promotion-uppercase")
    public void listenPromotion(PromotionMessage message) {
        log.info("Processing uppercase promotion: {}", message);
    }
}
