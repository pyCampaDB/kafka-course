package com.pycampadb.msvc.command.action.orderpayment;

import com.pycampadb.msvc.api.request.orderpayment.OnlineOrderRequest;

public interface OnlineOrderAction {
    void sendToKafka(OnlineOrderRequest request);
}
