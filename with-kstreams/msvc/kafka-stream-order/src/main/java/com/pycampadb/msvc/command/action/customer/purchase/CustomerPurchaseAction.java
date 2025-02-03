package com.pycampadb.msvc.command.action.customer.purchase;

import com.pycampadb.msvc.api.request.customer.purchase.CustomerPurchaseMobileRequest;
import com.pycampadb.msvc.api.request.customer.purchase.CustomerPurchaseWebRequest;

public interface CustomerPurchaseAction {
    String publishMobileToKafka(CustomerPurchaseMobileRequest request);
    String publishWebToKafka(CustomerPurchaseWebRequest request);
}
