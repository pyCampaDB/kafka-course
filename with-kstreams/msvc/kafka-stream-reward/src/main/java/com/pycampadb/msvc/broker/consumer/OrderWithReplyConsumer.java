package com.pycampadb.msvc.broker.consumer;

import com.pycampadb.msvc.broker.message.OrderMessage;
import com.pycampadb.msvc.broker.message.OrderReplyMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface OrderWithReplyConsumer {
    OrderReplyMessage consumeOrder(ConsumerRecord<String, OrderMessage> consumerRecord);
}
