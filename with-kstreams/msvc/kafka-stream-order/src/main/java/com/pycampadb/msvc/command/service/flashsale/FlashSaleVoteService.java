package com.pycampadb.msvc.command.service.flashsale;

import com.pycampadb.msvc.api.request.flashsale.FlashSaleVoteRequest;

public interface FlashSaleVoteService {
    String createFlashSaleVote(FlashSaleVoteRequest request);
}
