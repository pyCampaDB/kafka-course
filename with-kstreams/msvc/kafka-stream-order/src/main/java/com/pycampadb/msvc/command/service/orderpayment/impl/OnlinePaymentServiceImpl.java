package com.pycampadb.msvc.command.service.orderpayment.impl;

import com.pycampadb.msvc.api.request.orderpayment.OnlinePaymentRequest;
import com.pycampadb.msvc.command.action.orderpayment.OnlinePaymentAction;
import com.pycampadb.msvc.command.service.orderpayment.OnlinePaymentService;
import org.springframework.stereotype.Service;

@Service
public class OnlinePaymentServiceImpl implements OnlinePaymentService {
    private final OnlinePaymentAction action;

    public OnlinePaymentServiceImpl(OnlinePaymentAction action) {
        this.action = action;
    }

    @Override
    public void createOnlinePayment(OnlinePaymentRequest request) {
        action.sendToKafka(request);
    }
}
