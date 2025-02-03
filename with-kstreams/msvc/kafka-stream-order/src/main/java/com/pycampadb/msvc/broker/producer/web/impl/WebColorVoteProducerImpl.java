package com.pycampadb.msvc.broker.producer.web.impl;

import com.pycampadb.msvc.broker.message.web.WebColorVoteMessage;
import com.pycampadb.msvc.broker.producer.web.WebColorVoteProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebColorVoteProducerImpl implements WebColorVoteProducer {
    private final KafkaTemplate<String, WebColorVoteMessage> kafkaTemplate;

    public WebColorVoteProducerImpl(KafkaTemplate<String, WebColorVoteMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publishColorVote(WebColorVoteMessage message) {
        kafkaTemplate.send("t-commodity-web-vote-color",message.getUsername(), message);
    }
}
