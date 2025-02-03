package com.pycampadb.msvc.command.service.customer.purchase.impl;

import com.pycampadb.msvc.api.request.customer.purchase.CustomerPurchaseMobileRequest;
import com.pycampadb.msvc.api.request.customer.purchase.CustomerPurchaseWebRequest;
import com.pycampadb.msvc.command.action.customer.purchase.CustomerPurchaseAction;
import com.pycampadb.msvc.command.service.customer.purchase.CustomerPurchaseService;
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
