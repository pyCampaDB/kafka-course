package com.pycampadb.msvc.command.action.orderpayment.impl;

import com.pycampadb.msvc.api.request.orderpayment.OnlinePaymentRequest;
import com.pycampadb.msvc.broker.message.orderpayment.OnlinePaymentMessage;
import com.pycampadb.msvc.broker.producer.orderpayment.OnlinePaymentProducer;
import com.pycampadb.msvc.command.action.orderpayment.OnlinePaymentAction;
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
