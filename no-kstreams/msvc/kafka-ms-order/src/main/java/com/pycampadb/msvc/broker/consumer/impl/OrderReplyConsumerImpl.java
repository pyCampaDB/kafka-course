package com.pycampadb.msvc.broker.consumer.impl;

import com.pycampadb.msvc.broker.consumer.OrderReplyConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderReplyConsumerImpl implements OrderReplyConsumer {
    private static final Logger log = LoggerFactory.getLogger(OrderReplyConsumerImpl.class);

    @Override
    @KafkaListener(topics = "t-commodity-order-reply")
    public void consumeOrderReply(String message) {
        log.info("Consumed order reply message: {}", message);
    }
}
