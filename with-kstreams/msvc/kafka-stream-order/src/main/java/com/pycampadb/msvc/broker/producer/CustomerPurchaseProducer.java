package com.pycampadb.msvc.broker.producer;

import com.pycampadb.msvc.broker.message.CustomerPurchaseMobileMessage;
import com.pycampadb.msvc.broker.message.CustomerPurchaseWebMessage;

public interface CustomerPurchaseProducer {
    void publishCustomerPurchaseWebMessage(CustomerPurchaseWebMessage message);
    void publishCustomerPurchaseMobileMessage(CustomerPurchaseMobileMessage message);
}
