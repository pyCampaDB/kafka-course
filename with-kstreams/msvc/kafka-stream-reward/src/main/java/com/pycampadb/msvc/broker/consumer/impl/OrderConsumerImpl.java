package com.pycampadb.msvc.broker.consumer.impl;

import com.pycampadb.msvc.broker.consumer.OrderConsumer;
import com.pycampadb.msvc.broker.message.OrderMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.Objects;

//@Service
public class OrderConsumerImpl implements OrderConsumer {
    private static final Logger log = LoggerFactory.getLogger(OrderConsumerImpl.class);

    @KafkaListener(topics = "t-commodity-order")
    @Override
    public void consumeOrder(ConsumerRecord<String, OrderMessage> consumerRecord) {
        var headers = consumerRecord.headers();
        var orderMessage = consumerRecord.value();

        log.info("Kafka headers:");
        headers.forEach(header -> log.info("Header {} : {}", header.key(), new String(header.value())));
        log.info("Order: {}", orderMessage);

        var lastHeader = headers.lastHeader("surpriseBonus");
        var bonusPercentage = Objects.isNull(lastHeader) ? 0 : Integer.parseInt(new String(lastHeader.value()));
        log.info("Surprise bonus is {}%", bonusPercentage);
    }
}
