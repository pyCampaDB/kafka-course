package com.pycampadb.msvc.command.action;

import com.pycampadb.msvc.api.request.OnlineOrderRequest;

public interface OnlineOrderAction {
    void sendToKafka(OnlineOrderRequest request);
}
