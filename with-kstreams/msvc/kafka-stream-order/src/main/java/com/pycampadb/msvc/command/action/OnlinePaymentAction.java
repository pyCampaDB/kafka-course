package com.pycampadb.msvc.command.action;

import com.pycampadb.msvc.api.request.OnlinePaymentRequest;

public interface OnlinePaymentAction {
    void sendToKafka(OnlinePaymentRequest request);
}
