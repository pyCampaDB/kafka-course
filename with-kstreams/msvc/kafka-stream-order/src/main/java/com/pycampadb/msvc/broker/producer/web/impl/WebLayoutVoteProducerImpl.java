package com.pycampadb.msvc.broker.producer.web.impl;

import com.pycampadb.msvc.broker.message.web.WebLayoutVoteMessage;
import com.pycampadb.msvc.broker.producer.web.WebLayoutVoteProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebLayoutVoteProducerImpl implements WebLayoutVoteProducer {
    private final KafkaTemplate<String, WebLayoutVoteMessage> kafkaTemplate;

    public WebLayoutVoteProducerImpl(KafkaTemplate<String, WebLayoutVoteMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publishLayoutVote(WebLayoutVoteMessage message) {
        kafkaTemplate.send("t-commodity-web-vote-layout", message.getUsername(), message);
    }
}
