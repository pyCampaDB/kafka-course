package com.pycampadb.msvc.command.service.impl;

import com.pycampadb.msvc.api.request.CustomerPurchaseMobileRequest;
import com.pycampadb.msvc.api.request.CustomerPurchaseWebRequest;
import com.pycampadb.msvc.command.action.CustomerPurchaseAction;
import com.pycampadb.msvc.command.service.CustomerPurchaseService;
import org.springframework.stereotype.Service;

@Service
public class CustomerPurchaseServiceImpl implements CustomerPurchaseService {
    private final CustomerPurchaseAction action;

    public CustomerPurchaseServiceImpl(CustomerPurchaseAction action) {
        this.action = action;
    }

    @Override
    public String createPurchaseMobile(CustomerPurchaseMobileRequest request) {
        return action.publishMobileToKafka(request);
    }

    @Override
    public String createPurchaseWeb(CustomerPurchaseWebRequest request) {
        return action.publishWebToKafka(request);
    }
}
