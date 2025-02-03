package com.pycampadb.msvc.broker.producer.orderpayment;

import com.pycampadb.msvc.broker.message.orderpayment.OnlineOrderMessage;

public interface OnlineOrderProducer {
    void publishToKafka(OnlineOrderMessage message);
}
