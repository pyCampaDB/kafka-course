package com.pycampadb.msvc.command.action.impl;

import com.pycampadb.msvc.api.request.DiscountRequest;
import com.pycampadb.msvc.broker.message.DiscountMessage;
import com.pycampadb.msvc.broker.producer.DiscountProducer;
import com.pycampadb.msvc.command.action.DiscountAction;
import org.springframework.stereotype.Component;

@Component
public class DiscountActionImpl implements DiscountAction {
    private final DiscountProducer producer;

    public DiscountActionImpl(DiscountProducer producer) {
        this.producer = producer;
    }

    @Override
    public DiscountMessage convertToDiscountMessage(DiscountRequest request) {
        return new DiscountMessage(request.getDiscountCode(), request.getDiscountPercentage());
    }

    @Override
    public void sendToKafka(DiscountMessage message) {
        producer.publish(message);
    }
}
