package com.pycampadb.msvc.broker.producer.customer.purchase;

import com.pycampadb.msvc.broker.message.customer.purchase.CustomerPurchaseMobileMessage;
import com.pycampadb.msvc.broker.message.customer.purchase.CustomerPurchaseWebMessage;

public interface CustomerPurchaseProducer {
    void publishCustomerPurchaseWebMessage(CustomerPurchaseWebMessage message);
    void publishCustomerPurchaseMobileMessage(CustomerPurchaseMobileMessage message);
}
