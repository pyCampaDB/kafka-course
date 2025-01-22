package com.pycampadb.msvc.broker.stream.inventory.impl;

import com.pycampadb.msvc.broker.message.InventoryMessage;
import com.pycampadb.msvc.broker.stream.inventory.InventoryStream;
import com.pycampadb.msvc.util.InventoryTimestampExtractor;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.serializer.JsonSerde;

import java.time.*;

//@Component
public class InventorySevenStream implements InventoryStream {
    private static final String INPUT_TOPIC = "t-commodity-inventory";
    private static final String OUTPUT_TOPIC = "t-commodity-inventory-seven";
    private static final Logger log = LoggerFactory.getLogger(InventorySevenStream.class);

    @Override
    @Autowired
    public void kStreamInventory(StreamsBuilder builder) {
        var stringSerde = Serdes.String();
        var inventorySerde = new JsonSerde<>(InventoryMessage.class);
        var inventoryTimestampExtractor = new InventoryTimestampExtractor();
        var longSerde = Serdes.Long();

        var inactivityGap = Duration.ofMinutes(30L);
        var windowsSerde = WindowedSerdes.sessionWindowedSerdeFrom(String.class);

        var sessionWindows = SessionWindows.ofInactivityGapWithNoGrace(inactivityGap);
        var zoneId = ZoneId.of("Europe/Madrid")
                        .getRules()
                        .getOffset(LocalDateTime.now())
                        .getId();



        builder.stream(INPUT_TOPIC, Consumed.with(stringSerde, inventorySerde, inventoryTimestampExtractor, null))
                .groupByKey()
                .windowedBy(sessionWindows)
                .count()
                .toStream()
                .filter(
                        (k,v) -> v!=null && v>0
                )
                .peek(
                        (k, v) -> {
                            var windowStartTime = Instant.ofEpochMilli(k.window().start()).atOffset(
                                    ZoneOffset.of(zoneId)
                            );
                            var windowEndTime = Instant.ofEpochMilli(k.window().end()).atOffset(
                                    ZoneOffset.of(zoneId)
                            );
                            log.info("[{}@{}/{}], {}",k.key(), windowStartTime, windowEndTime, v);
                        }
                )
                .to(OUTPUT_TOPIC, Produced.with(windowsSerde, longSerde));
    }
}
