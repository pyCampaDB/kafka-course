package com.pycampadb.msvc.broker.consumer;

import com.pycampadb.msvc.broker.message.OrderMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface OrderConsumer {
    void consumeOrder(ConsumerRecord<String, OrderMessage> consumerRecord);
}
