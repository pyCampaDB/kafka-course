package com.pycampadb.msvc.broker.producer.flashsale.impl;

import com.pycampadb.msvc.broker.message.flashsale.FlashSaleVoteMessage;
import com.pycampadb.msvc.broker.producer.flashsale.FlashSaleVoteProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class FlashSaleVoteProducerImpl implements FlashSaleVoteProducer {
    private final KafkaTemplate<String, FlashSaleVoteMessage> kafkaTemplate;

    public FlashSaleVoteProducerImpl(KafkaTemplate<String, FlashSaleVoteMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publishFlashSaleVote(FlashSaleVoteMessage message) {
        kafkaTemplate.send("t-commodity-flashsale-vote", message);
    }
}
