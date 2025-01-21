package com.pycampadb.msvc.broker.consumer.impl;

import com.pycampadb.msvc.broker.consumer.OrderConsumer;
import com.pycampadb.msvc.broker.message.OrderMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumerImpl implements OrderConsumer {
    private static final Logger log = LoggerFactory.getLogger(OrderConsumerImpl.class);

    @Override
    @KafkaListener(topics = "t-commodity-order")
    public void listenOrder(OrderMessage orderMessage) {
        var totalItemAmount = orderMessage.getPrice() + orderMessage.getQuantity();
        log.info(
                "Processing order {}, item {}, credit card number {}, total amount {}",
                orderMessage.getOrderNumber(),
                orderMessage.getItemName(),
                orderMessage.getCreditCardNumber(),
                totalItemAmount
        );
    }
}
