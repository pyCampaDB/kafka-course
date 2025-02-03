package com.pycampadb.msvc.broker.producer.commodity.impl;

import com.pycampadb.msvc.broker.message.commodity.OrderMessage;
import com.pycampadb.msvc.broker.producer.commodity.OrderProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

@Service
public class OrderProducerImpl implements OrderProducer {
    private static final Logger log = LoggerFactory.getLogger(OrderProducerImpl.class);
    private final KafkaTemplate<String, OrderMessage> kafkaTemplate;

    public OrderProducerImpl(KafkaTemplate<String, OrderMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendOrder (OrderMessage orderMessage){
        var producerRecord = buildProducerRecord(orderMessage);
        kafkaTemplate.send(producerRecord)
                .whenComplete((recordMetadata, ex) -> {
                    if (ex==null)
                        log.info("Order {} sent successfully", orderMessage.getOrderNumber());
                    else
                        log.error("Failed to send order {}", orderMessage.getOrderNumber(), ex);
                });
        log.info("Just a dummy message for order {}, item {}", orderMessage.getOrderNumber(), orderMessage.getItemName());
    }

    private ProducerRecord<String, OrderMessage> buildProducerRecord (OrderMessage message){
        var surpriseBonus = StringUtils.startsWithIgnoreCase(message.getOrderLocation(), "A") ? 25 : 15;
        var kafkaHeaders = new ArrayList<Header>();
        var surpriseBonusHeader = new RecordHeader("surpriseBonus", Integer.toString(surpriseBonus).getBytes());
        kafkaHeaders.add(surpriseBonusHeader);
        return new ProducerRecord<>(
                "t-commodity-order",
                null,
                message.getOrderNumber(),   //key
                message,                    //message
                kafkaHeaders                //headers
        );
    }
}
