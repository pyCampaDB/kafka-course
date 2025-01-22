package com.pycampadb.msvc.command.service.impl;

import com.pycampadb.msvc.api.request.OnlineOrderRequest;
import com.pycampadb.msvc.command.action.OnlineOrderAction;
import com.pycampadb.msvc.command.service.OnlineOrderService;
import org.springframework.stereotype.Service;

@Service
public class OnlineOrderServiceImpl implements OnlineOrderService {
    private final OnlineOrderAction action;

    public OnlineOrderServiceImpl(OnlineOrderAction action) {
        this.action = action;
    }

    @Override
    public void createOnlineOrder(OnlineOrderRequest request) {
        action.sendToKafka(request);
    }
}
