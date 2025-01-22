package com.pycampadb.msvc.util;

import com.pycampadb.msvc.broker.message.OnlinePaymentMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.streams.processor.TimestampExtractor;

public class OnlinePaymentTimestampExtractor implements TimestampExtractor {
    @Override
    public long extract(ConsumerRecord<Object, Object> consumerRecord, long partitionTime) {
        var paymentMessage = (OnlinePaymentMessage) consumerRecord.value();
        return paymentMessage != null ?
                paymentMessage.getPaymentDateTime().toInstant().toEpochMilli() : consumerRecord.timestamp();
    }
}
