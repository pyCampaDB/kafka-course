package com.pycampadb.msvc.command.service.customer.purchase;

import com.pycampadb.msvc.api.request.customer.purchase.CustomerPurchaseMobileRequest;
import com.pycampadb.msvc.api.request.customer.purchase.CustomerPurchaseWebRequest;

public interface CustomerPurchaseService {
    String createPurchaseMobile(CustomerPurchaseMobileRequest request);
    String createPurchaseWeb(CustomerPurchaseWebRequest request);
}
