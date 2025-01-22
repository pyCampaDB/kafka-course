package com.pycampadb.msvc.command.service.impl;

import com.pycampadb.msvc.api.request.OnlinePaymentRequest;
import com.pycampadb.msvc.command.action.OnlinePaymentAction;
import com.pycampadb.msvc.command.service.OnlinePaymentService;
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
