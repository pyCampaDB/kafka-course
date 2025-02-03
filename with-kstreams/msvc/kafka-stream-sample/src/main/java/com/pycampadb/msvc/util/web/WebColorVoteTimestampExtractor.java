package com.pycampadb.msvc.util.web;

import com.pycampadb.msvc.broker.message.WebColorVoteMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.streams.processor.TimestampExtractor;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class WebColorVoteTimestampExtractor implements TimestampExtractor {
    private static final ZoneOffset ZONE_OFFSET = ZoneOffset.of(
            ZoneId.of("Europe/Madrid")
                    .getRules()
                    .getOffset(LocalDateTime.now())
                    .getId()
    );
    @Override
    public long extract(ConsumerRecord<Object, Object> consumerRecord, long partitionTime) {
        var webColorVoteMessage = (WebColorVoteMessage) consumerRecord.value();
        return webColorVoteMessage != null ? webColorVoteMessage.getVoteDateTime().toInstant(ZONE_OFFSET).toEpochMilli() :
                consumerRecord.timestamp();
    }
}
