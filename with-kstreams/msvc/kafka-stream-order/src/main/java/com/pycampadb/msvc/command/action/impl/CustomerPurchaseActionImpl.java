package com.pycampadb.msvc.command.action.impl;

import com.pycampadb.msvc.api.request.CustomerPurchaseMobileRequest;
import com.pycampadb.msvc.api.request.CustomerPurchaseWebRequest;
import com.pycampadb.msvc.broker.message.CustomerPurchaseMobileMessage;
import com.pycampadb.msvc.broker.message.CustomerPurchaseWebMessage;
import com.pycampadb.msvc.broker.producer.CustomerPurchaseProducer;
import com.pycampadb.msvc.command.action.CustomerPurchaseAction;
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
