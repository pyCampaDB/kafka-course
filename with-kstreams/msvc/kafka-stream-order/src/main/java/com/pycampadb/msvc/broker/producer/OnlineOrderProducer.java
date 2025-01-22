package com.pycampadb.msvc.broker.producer;

import com.pycampadb.msvc.broker.message.OnlineOrderMessage;

public interface OnlineOrderProducer {
    void publishToKafka(OnlineOrderMessage message);
}
