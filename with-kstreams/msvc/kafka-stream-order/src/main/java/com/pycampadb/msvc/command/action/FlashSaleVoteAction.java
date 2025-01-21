package com.pycampadb.msvc.command.action;

import com.pycampadb.msvc.api.request.FlashSaleVoteRequest;

public interface FlashSaleVoteAction {
    String sendFlashSaleVoteToKafka(FlashSaleVoteRequest request);
}
