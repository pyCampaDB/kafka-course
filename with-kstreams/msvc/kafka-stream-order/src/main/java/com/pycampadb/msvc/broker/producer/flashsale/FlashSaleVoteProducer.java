package com.pycampadb.msvc.broker.producer.flashsale;

import com.pycampadb.msvc.broker.message.flashsale.FlashSaleVoteMessage;

public interface FlashSaleVoteProducer {
    void publishFlashSaleVote(FlashSaleVoteMessage message);
}
