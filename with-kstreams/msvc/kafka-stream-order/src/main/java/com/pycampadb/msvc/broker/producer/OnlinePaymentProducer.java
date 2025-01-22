package com.pycampadb.msvc.broker.producer;

import com.pycampadb.msvc.broker.message.OnlinePaymentMessage;

public interface OnlinePaymentProducer {
    void publishToKafka(OnlinePaymentMessage message);
}
