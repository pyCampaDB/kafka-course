package com.pycampadb.msvc.command.action.customer.purchase.impl;

import com.pycampadb.msvc.api.request.customer.purchase.CustomerPurchaseMobileRequest;
import com.pycampadb.msvc.api.request.customer.purchase.CustomerPurchaseWebRequest;
import com.pycampadb.msvc.broker.message.customer.purchase.CustomerPurchaseMobileMessage;
import com.pycampadb.msvc.broker.message.customer.purchase.CustomerPurchaseWebMessage;
import com.pycampadb.msvc.broker.producer.customer.purchase.CustomerPurchaseProducer;
import com.pycampadb.msvc.command.action.customer.purchase.CustomerPurchaseAction;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CustomerPurchaseActionImpl implements CustomerPurchaseAction {
    private final CustomerPurchaseProducer producer;

    public CustomerPurchaseActionImpl(CustomerPurchaseProducer producer) {
        this.producer = producer;
    }

    @Override
    public String publishMobileToKafka(CustomerPurchaseMobileRequest request) {
        var purchaseNumber = "CP-MOBILE-" + UUID.randomUUID();
        var location = new CustomerPurchaseMobileMessage.Location(
                request.getLocation().getLatitude(),
                request.getLocation().getLongitude()
        );

        var message = new CustomerPurchaseMobileMessage(
                purchaseNumber,
                request.getPurchaseAmount(),
                request.getMobileAppVersion(),
                request.getOperatingSystem(),
                location
        );

        producer.publishCustomerPurchaseMobileMessage(message);
        return purchaseNumber;
    }

    @Override
    public String publishWebToKafka(CustomerPurchaseWebRequest request) {
        var purchaseNumber = "CP-WEB-"+UUID.randomUUID();
        var message = new CustomerPurchaseWebMessage(
                purchaseNumber,
                request.getPurchaseAmount(),
                request.getBrowser(),
                request.getOperatingSystem()
        );

        producer.publishCustomerPurchaseWebMessage(message);
        return purchaseNumber;
    }
}
