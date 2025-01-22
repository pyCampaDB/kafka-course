package com.pycampadb.msvc.command.service;

import com.pycampadb.msvc.api.request.OnlinePaymentRequest;

public interface OnlinePaymentService {
    void createOnlinePayment (OnlinePaymentRequest request);
}
