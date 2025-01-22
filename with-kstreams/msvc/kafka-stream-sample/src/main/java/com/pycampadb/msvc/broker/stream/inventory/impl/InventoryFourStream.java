package com.pycampadb.msvc.broker.stream.inventory.impl;

import com.pycampadb.msvc.broker.message.InventoryMessage;
import com.pycampadb.msvc.broker.stream.inventory.InventoryStream;
import com.pycampadb.msvc.util.InventoryTimestampExtractor;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.serializer.JsonSerde;

//@Component
public class InventoryFourStream implements InventoryStream {
    private static final String INPUT_TOPIC = "t-commodity-inventory";
    private static final String OUTPUT_TOPIC = "t-commodity-inventory-four";
    @Override
    @Autowired
    public void kStreamInventory(StreamsBuilder builder) {
        var stringSerde = Serdes.String();
        var inventorySerde = new JsonSerde<>(InventoryMessage.class);
        var inventoryTimestampExtractor = new InventoryTimestampExtractor();

        builder.stream(INPUT_TOPIC, Consumed.with(stringSerde, inventorySerde, inventoryTimestampExtractor, null))
                .to(OUTPUT_TOPIC, Produced.with(stringSerde, inventorySerde));
    }
}
