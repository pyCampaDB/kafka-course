package com.pycampadb.msvc.broker.producer.impl;

import com.pycampadb.msvc.broker.message.FeedbackMessage;
import com.pycampadb.msvc.broker.producer.FeedbackProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class FeedbackProducerImpl implements FeedbackProducer {
    private final KafkaTemplate<String, FeedbackMessage> kafkaTemplate;

    public FeedbackProducerImpl(KafkaTemplate<String, FeedbackMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publishFeedback(FeedbackMessage message) {
        kafkaTemplate.send("t-commodity-feedback", message);
    }
}
