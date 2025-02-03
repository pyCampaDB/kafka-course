package com.pycampadb.msvc.broker.producer.orderpayment.impl;

import com.pycampadb.msvc.broker.message.orderpayment.OnlinePaymentMessage;
import com.pycampadb.msvc.broker.producer.orderpayment.OnlinePaymentProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OnlinePaymentProducerImpl implements OnlinePaymentProducer {
    private final KafkaTemplate<String, OnlinePaymentMessage> kafkaTemplate;

    public OnlinePaymentProducerImpl(KafkaTemplate<String, OnlinePaymentMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publishToKafka(OnlinePaymentMessage message) {
        kafkaTemplate.send("t-commodity-online-payment", message.getOnlineOrderNumber(), message);
    }
}
