package com.pycampadb.msvc.command.action.impl;

import com.pycampadb.msvc.api.request.FlashSaleVoteRequest;
import com.pycampadb.msvc.broker.message.FlashSaleVoteMessage;
import com.pycampadb.msvc.broker.producer.FlashSaleVoteProducer;
import com.pycampadb.msvc.command.action.FlashSaleVoteAction;
import org.springframework.stereotype.Component;

@Component
public class FlashSaleVoteActionImpl implements FlashSaleVoteAction {
    private final FlashSaleVoteProducer producer;

    public FlashSaleVoteActionImpl(FlashSaleVoteProducer producer) {
        this.producer = producer;
    }

    @Override
    public String sendFlashSaleVoteToKafka(FlashSaleVoteRequest request) {
        var message = new FlashSaleVoteMessage(request.getCustomerId(), request.getItemName());
        producer.publishFlashSaleVote(message);
        return message.getCustomerId();
    }
}
