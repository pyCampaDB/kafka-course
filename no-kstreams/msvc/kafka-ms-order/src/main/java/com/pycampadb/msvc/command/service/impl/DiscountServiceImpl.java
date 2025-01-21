package com.pycampadb.msvc.command.service.impl;

import com.pycampadb.msvc.api.request.DiscountRequest;
import com.pycampadb.msvc.command.action.DiscountAction;
import com.pycampadb.msvc.command.service.DiscountService;
import org.springframework.stereotype.Service;

@Service
public class DiscountServiceImpl implements DiscountService {
    private final DiscountAction action;

    public DiscountServiceImpl(DiscountAction action) {
        this.action = action;
    }

    @Override
    public void createDiscount(DiscountRequest request) {
        var message = action.convertToDiscountMessage(request);
        action.sendToKafka(message);
    }
}
