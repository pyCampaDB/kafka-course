package com.pycampadb.msvc.command.action.discount;

import com.pycampadb.msvc.api.request.discount.DiscountRequest;
import com.pycampadb.msvc.broker.message.discount.DiscountMessage;

public interface DiscountAction {
    DiscountMessage convertToDiscountMessage (DiscountRequest request);
    void sendToKafka(DiscountMessage message);
}
