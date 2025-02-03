package com.pycampadb.msvc.command.service.discount.impl;

import com.pycampadb.msvc.api.request.discount.DiscountRequest;
import com.pycampadb.msvc.command.action.discount.DiscountAction;
import com.pycampadb.msvc.command.service.discount.DiscountService;
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
