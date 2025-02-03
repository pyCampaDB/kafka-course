package com.pycampadb.msvc.command.action.flashsale;

import com.pycampadb.msvc.api.request.flashsale.FlashSaleVoteRequest;

public interface FlashSaleVoteAction {
    String sendFlashSaleVoteToKafka(FlashSaleVoteRequest request);
}
