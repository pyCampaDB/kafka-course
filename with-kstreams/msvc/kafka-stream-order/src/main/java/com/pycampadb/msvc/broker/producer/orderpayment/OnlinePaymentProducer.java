package com.pycampadb.msvc.broker.producer.orderpayment;

import com.pycampadb.msvc.broker.message.orderpayment.OnlinePaymentMessage;

public interface OnlinePaymentProducer {
    void publishToKafka(OnlinePaymentMessage message);
}
