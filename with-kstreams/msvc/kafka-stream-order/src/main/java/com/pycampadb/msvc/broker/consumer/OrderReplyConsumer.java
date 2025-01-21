package com.pycampadb.msvc.broker.consumer;

public interface OrderReplyConsumer {
    void consumeOrderReply(String message);
}
