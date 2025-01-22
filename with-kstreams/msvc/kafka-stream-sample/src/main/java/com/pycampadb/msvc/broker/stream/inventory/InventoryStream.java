package com.pycampadb.msvc.broker.stream.inventory;

import org.apache.kafka.streams.StreamsBuilder;

public interface InventoryStream {
    void kStreamInventory (StreamsBuilder builder);
}
