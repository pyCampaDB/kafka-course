package com.pycampadb.msvc.util;

import com.pycampadb.msvc.broker.message.OnlineOrderMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.streams.processor.TimestampExtractor;

public class OnlineOrderTimestampExtractor implements TimestampExtractor {
    @Override
    public long extract(ConsumerRecord<Object, Object> consumerRecord, long partitionTime) {
        var onlineOrderMessage = (OnlineOrderMessage) consumerRecord.value();
        return onlineOrderMessage!=null ? onlineOrderMessage.getOrderDateTime().toInstant().toEpochMilli() :
                consumerRecord.timestamp();
    }
}
