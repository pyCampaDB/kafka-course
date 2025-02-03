package com.pycampadb.msvc.command.action.orderpayment.impl;

import com.pycampadb.msvc.api.request.orderpayment.OnlineOrderRequest;
import com.pycampadb.msvc.broker.message.orderpayment.OnlineOrderMessage;
import com.pycampadb.msvc.broker.producer.orderpayment.OnlineOrderProducer;
import com.pycampadb.msvc.command.action.orderpayment.OnlineOrderAction;
import org.springframework.stereotype.Component;

@Component
public class OnlineOrderActionImpl implements OnlineOrderAction {
    private final OnlineOrderProducer producer;

    public OnlineOrderActionImpl(OnlineOrderProducer producer) {
        this.producer = producer;
    }

    @Override
    public void sendToKafka(OnlineOrderRequest request) {
        var message = new OnlineOrderMessage(
                request.getOnlineOrderNumber(),
                request.getOrderDateTime(),
                request.getTotalAmount(),
                request.getUsername()
        );
        producer.publishToKafka(message);
    }
}
