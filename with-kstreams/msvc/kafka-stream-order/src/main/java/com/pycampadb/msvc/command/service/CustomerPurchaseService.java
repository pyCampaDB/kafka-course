package com.pycampadb.msvc.command.service;

import com.pycampadb.msvc.api.request.CustomerPurchaseMobileRequest;
import com.pycampadb.msvc.api.request.CustomerPurchaseWebRequest;

public interface CustomerPurchaseService {
    String createPurchaseMobile(CustomerPurchaseMobileRequest request);
    String createPurchaseWeb(CustomerPurchaseWebRequest request);
}
