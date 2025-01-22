package com.pycampadb.msvc.command.action.impl;

import com.pycampadb.msvc.api.request.OnlinePaymentRequest;
import com.pycampadb.msvc.broker.message.OnlinePaymentMessage;
import com.pycampadb.msvc.broker.producer.OnlinePaymentProducer;
import com.pycampadb.msvc.command.action.OnlinePaymentAction;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OnlinePaymentActionImpl implements OnlinePaymentAction {
    private final OnlinePaymentProducer producer;

    public OnlinePaymentActionImpl(OnlinePaymentProducer producer) {
        this.producer = producer;
    }

    @Override
    public void sendToKafka(OnlinePaymentRequest request) {
        var message = new OnlinePaymentMessage(
                request.getOnlineOrderNumber(),
                request.getPaymentDateTime(),
                "PAY-"+ UUID.randomUUID(),
                request.getPaymentMethod()
        );
        producer.publishToKafka(message);
    }
}
