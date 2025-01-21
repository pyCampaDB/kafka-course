package com.pycampadb.msvc.command.action;

import com.pycampadb.msvc.api.request.DiscountRequest;
import com.pycampadb.msvc.broker.message.DiscountMessage;

public interface DiscountAction {
    DiscountMessage convertToDiscountMessage (DiscountRequest request);
    void sendToKafka(DiscountMessage message);
}
