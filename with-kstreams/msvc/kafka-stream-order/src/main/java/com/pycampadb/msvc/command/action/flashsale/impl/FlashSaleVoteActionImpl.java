package com.pycampadb.msvc.command.action.flashsale.impl;

import com.pycampadb.msvc.api.request.flashsale.FlashSaleVoteRequest;
import com.pycampadb.msvc.broker.message.flashsale.FlashSaleVoteMessage;
import com.pycampadb.msvc.broker.producer.flashsale.FlashSaleVoteProducer;
import com.pycampadb.msvc.command.action.flashsale.FlashSaleVoteAction;
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
