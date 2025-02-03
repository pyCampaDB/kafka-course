package com.pycampadb.msvc.util.web;

import com.pycampadb.msvc.broker.message.WebLayoutVoteMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.streams.processor.TimestampExtractor;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class WebColorLayoutTimestampExtractor implements TimestampExtractor {
    private static final ZoneOffset ZONE_OFFSET = ZoneOffset.of(
            ZoneId.of("Europe/Madrid")
                    .getRules()
                    .getOffset(LocalDateTime.now())
                    .getId()
    );
    @Override
    public long extract(ConsumerRecord<Object, Object> consumerRecord, long partitionTime) {
        var webLayoutVoteMessage = (WebLayoutVoteMessage) consumerRecord.value();
        return webLayoutVoteMessage != null ? webLayoutVoteMessage.getVoteDateTime().toInstant(ZONE_OFFSET).toEpochMilli() :
                consumerRecord.timestamp();
    }
}
