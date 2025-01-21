package com.pycampadb.msvc.command.action;

import com.pycampadb.msvc.api.request.CustomerPurchaseMobileRequest;
import com.pycampadb.msvc.api.request.CustomerPurchaseWebRequest;

public interface CustomerPurchaseAction {
    String publishMobileToKafka(CustomerPurchaseMobileRequest request);
    String publishWebToKafka(CustomerPurchaseWebRequest request);
}
