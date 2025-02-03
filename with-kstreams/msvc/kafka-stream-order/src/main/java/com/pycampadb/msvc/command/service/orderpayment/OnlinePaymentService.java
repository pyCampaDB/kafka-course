package com.pycampadb.msvc.command.service.orderpayment;

import com.pycampadb.msvc.api.request.orderpayment.OnlinePaymentRequest;

public interface OnlinePaymentService {
    void createOnlinePayment (OnlinePaymentRequest request);
}
