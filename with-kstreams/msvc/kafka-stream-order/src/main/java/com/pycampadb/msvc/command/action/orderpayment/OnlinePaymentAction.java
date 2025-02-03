package com.pycampadb.msvc.command.action.orderpayment;

import com.pycampadb.msvc.api.request.orderpayment.OnlinePaymentRequest;

public interface OnlinePaymentAction {
    void sendToKafka(OnlinePaymentRequest request);
}
