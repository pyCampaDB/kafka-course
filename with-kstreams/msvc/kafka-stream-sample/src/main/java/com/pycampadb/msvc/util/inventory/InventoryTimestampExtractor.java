package com.pycampadb.msvc.util.inventory;

import com.pycampadb.msvc.broker.message.InventoryMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.streams.processor.TimestampExtractor;

public class InventoryTimestampExtractor implements TimestampExtractor {
    @Override
    public long extract(ConsumerRecord<Object, Object> consumerRecord, long partitionTime) {
        var inventoryMessage = (InventoryMessage) consumerRecord.value();
        return inventoryMessage != null ? inventoryMessage.getTransactionTime().toInstant().toEpochMilli() : consumerRecord.timestamp();
    }
}
