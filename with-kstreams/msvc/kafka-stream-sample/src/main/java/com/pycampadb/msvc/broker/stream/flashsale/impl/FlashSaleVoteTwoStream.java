package com.pycampadb.msvc.broker.stream.flashsale.impl;

import com.pycampadb.msvc.broker.message.FlashSaleVoteMessage;
import com.pycampadb.msvc.broker.stream.flashsale.FlashSaleVoteStream;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.serializer.JsonSerde;

import java.time.OffsetDateTime;

//@Component
public class FlashSaleVoteTwoStream implements FlashSaleVoteStream {
    private static final String INPUT_TOPIC = "t-commodity-flashsale-vote";
    private static final String OUTPUT_TOPIC = "t-commodity-flashsale-vote-two-user-item";
    private static final String OUTPUT_RESULT_TOPIC = "t-commodity-flashsale-vote-two-result";

    @Override
    @Autowired
    @SuppressWarnings("deprecation") //transformValues está obsoleto
    public void flashSaleVoteStream(StreamsBuilder builder) {
        var stringSerde = Serdes.String();
        var flashSaleVoteSerde = new JsonSerde<>(FlashSaleVoteMessage.class);
        var voteStart = OffsetDateTime.now().plusMinutes(2);
        var voteEnd = OffsetDateTime.now().plusHours(1);
        builder.stream(INPUT_TOPIC, Consumed.with(stringSerde, flashSaleVoteSerde))
                .transformValues(() -> new FlashSaleVoteTwoValueTransformer(voteStart, voteEnd))
                .filter((key, transformedValue) -> transformedValue!= null)
                .map((k, v) -> KeyValue.pair(v.getCustomerId(), v.getItemName()))
                .to(OUTPUT_TOPIC);

        builder.table(OUTPUT_TOPIC, Consumed.with(stringSerde, stringSerde))
                .groupBy((user, votedItem) -> KeyValue.pair(votedItem, votedItem))
                .count()
                .toStream()
                .to(OUTPUT_RESULT_TOPIC);
    }
}
