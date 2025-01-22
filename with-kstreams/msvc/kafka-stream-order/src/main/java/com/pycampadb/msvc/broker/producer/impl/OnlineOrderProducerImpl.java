package com.pycampadb.msvc.broker.producer.impl;

import com.pycampadb.msvc.broker.message.OnlineOrderMessage;
import com.pycampadb.msvc.broker.producer.OnlineOrderProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OnlineOrderProducerImpl implements OnlineOrderProducer {
    private final KafkaTemplate<String, OnlineOrderMessage> kafkaTemplate;

    public OnlineOrderProducerImpl(KafkaTemplate<String, OnlineOrderMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publishToKafka(OnlineOrderMessage message) {
        kafkaTemplate.send("t-commodity-online-order", message.getOnlineOrderNumber(), message);
    }
}
