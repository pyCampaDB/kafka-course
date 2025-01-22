package com.pycampadb.msvc.broker.stream.inventory.impl;

import com.pycampadb.msvc.broker.message.InventoryMessage;
import com.pycampadb.msvc.broker.stream.inventory.InventoryStream;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Materialized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.serializer.JsonSerde;

//@Component
public class InventoryThreeStream implements InventoryStream {
    private static final String INPUT_TOPIC = "t-commodity-inventory";
    private static final String OUTPUT_TOPIC = "t-commodity-inventory-total-three";
    @Override
    @Autowired
    public void kStreamInventory(StreamsBuilder builder) {
        var stringSerde = Serdes.String();
        var inventorySerde = new JsonSerde<>(InventoryMessage.class);
        var longSerde = Serdes.Long();

        builder.stream(INPUT_TOPIC, Consumed.with(stringSerde, inventorySerde))
                .mapValues(
                        (item, inventory) ->
                                inventory.getType().equalsIgnoreCase("ADD") ?
                                        inventory.getQuantity() : -1 * inventory.getQuantity()
                )
                .groupByKey()
                .reduce(Long::sum, Materialized.with(stringSerde, longSerde))
                .toStream()
                .to(OUTPUT_TOPIC);
    }
}
