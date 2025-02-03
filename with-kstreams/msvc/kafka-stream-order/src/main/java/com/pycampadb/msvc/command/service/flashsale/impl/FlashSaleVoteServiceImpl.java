package com.pycampadb.msvc.command.service.flashsale.impl;

import com.pycampadb.msvc.api.request.flashsale.FlashSaleVoteRequest;
import com.pycampadb.msvc.command.action.flashsale.FlashSaleVoteAction;
import com.pycampadb.msvc.command.service.flashsale.FlashSaleVoteService;
import org.springframework.stereotype.Service;

@Service
public class FlashSaleVoteServiceImpl implements FlashSaleVoteService {
    private final FlashSaleVoteAction action;

    public FlashSaleVoteServiceImpl(FlashSaleVoteAction action) {
        this.action = action;
    }

    @Override
    public String createFlashSaleVote(FlashSaleVoteRequest request) {
        return action.sendFlashSaleVoteToKafka(request);
    }
}
