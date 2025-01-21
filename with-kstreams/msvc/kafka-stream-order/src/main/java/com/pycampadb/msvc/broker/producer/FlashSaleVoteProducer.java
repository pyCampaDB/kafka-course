package com.pycampadb.msvc.broker.producer;

import com.pycampadb.msvc.broker.message.FlashSaleVoteMessage;

public interface FlashSaleVoteProducer {
    void publishFlashSaleVote(FlashSaleVoteMessage message);
}
