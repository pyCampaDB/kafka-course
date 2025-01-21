package com.pycampadb.msvc.broker.stream.flashsale.impl;

import com.pycampadb.msvc.broker.message.FlashSaleVoteMessage;
import org.apache.kafka.streams.kstream.ValueTransformer;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.OffsetDateTime;

public class FlashSaleVoteTwoValueTransformer implements ValueTransformer<FlashSaleVoteMessage, FlashSaleVoteMessage> {

    private static final Logger log = LoggerFactory.getLogger(FlashSaleVoteTwoValueTransformer.class);
    private final long voteStartTime;
    private final long voteEndTime;
    private ProcessorContext processorContext;

    public FlashSaleVoteTwoValueTransformer(OffsetDateTime startDateTime, OffsetDateTime endDateTime) {
        this.voteStartTime = startDateTime.toInstant().toEpochMilli();
        this.voteEndTime = endDateTime.toInstant().toEpochMilli();
    }

    @Override
    public void init(ProcessorContext processorContext) {
        this.processorContext = processorContext;

    }

    @Override
    public FlashSaleVoteMessage transform(FlashSaleVoteMessage value) {
        var recordTime = processorContext.timestamp();
        return (recordTime >=voteStartTime && recordTime<=voteEndTime) ? value : null;
    }

    @Override
    public void close() {
        log.info("FlashSaleTwoVoteValueTransformer was closed");
    }
}
