package com.pycampadb.msvc.command.action.impl;

import com.pycampadb.msvc.api.request.OnlineOrderRequest;
import com.pycampadb.msvc.broker.message.OnlineOrderMessage;
import com.pycampadb.msvc.broker.producer.OnlineOrderProducer;
import com.pycampadb.msvc.command.action.OnlineOrderAction;
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
