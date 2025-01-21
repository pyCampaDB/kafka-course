package com.pycampadb.msvc.broker.stream.flashsale.impl;

import com.pycampadb.msvc.broker.message.FlashSaleVoteMessage;
import org.apache.kafka.streams.processor.api.FixedKeyProcessor;
import org.apache.kafka.streams.processor.api.FixedKeyProcessorContext;
import org.apache.kafka.streams.processor.api.FixedKeyRecord;

import java.time.OffsetDateTime;

public class FlashSaleVoteThreeFixedKeyProcessor implements FixedKeyProcessor<String, FlashSaleVoteMessage, FlashSaleVoteMessage> {

    private final long voteStartTime;
    private final long voteEndTime;
    private FixedKeyProcessorContext<String, FlashSaleVoteMessage> processorContext;

    public FlashSaleVoteThreeFixedKeyProcessor(OffsetDateTime voteStartTime, OffsetDateTime voteEndTime) {
        this.voteStartTime = voteStartTime.toInstant().toEpochMilli();
        this.voteEndTime = voteEndTime.toInstant().toEpochMilli();
    }

    @Override
    public void init(FixedKeyProcessorContext<String, FlashSaleVoteMessage> context) {
        this.processorContext = context;
    }

    @Override
    public void process(FixedKeyRecord<String, FlashSaleVoteMessage> fixedKeyRecord) {
        var recordTime = processorContext.currentSystemTimeMs();
        if(recordTime >= voteStartTime && recordTime <= voteEndTime)
            processorContext.forward(fixedKeyRecord.withValue(fixedKeyRecord.value()));
    }
}
