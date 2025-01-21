package com.pycampadb.msvc.broker.consumer.impl;

import com.pycampadb.msvc.broker.consumer.OrderWithReplyConsumer;
import com.pycampadb.msvc.broker.message.OrderMessage;
import com.pycampadb.msvc.broker.message.OrderReplyMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class OrderWithReplyConsumerImpl implements OrderWithReplyConsumer {
    private static final Logger log = LoggerFactory.getLogger(OrderWithReplyConsumerImpl.class);


    @Override
    @KafkaListener(topics = "t-commodity-order")
    @SendTo("t-commodity-order-reply")
    public OrderReplyMessage consumeOrder(ConsumerRecord<String, OrderMessage> consumerRecord) {
        var headers = consumerRecord.headers();
        var orderMessage = consumerRecord.value();

        log.info("Kafka headers:");
        headers.forEach(header -> log.info("Header {} : {}", header.key(), new String(header.value())));
        log.info("Order: {}", orderMessage);

        var lastHeader = headers.lastHeader("surpriseBonus");
        var bonusPercentage = Objects.isNull(lastHeader) ? 0 : Integer.parseInt(new String(lastHeader.value()));
        log.info("Surprise bonus is {}%", bonusPercentage);

        var orderReplyMessage = new OrderReplyMessage();
        orderReplyMessage.setReplyMessage(
                "Order confirmed with surprise bonus "
                        + bonusPercentage + "% from order id "
                        + orderMessage.getOrderNumber()
        );

        return orderReplyMessage;
    }
}
