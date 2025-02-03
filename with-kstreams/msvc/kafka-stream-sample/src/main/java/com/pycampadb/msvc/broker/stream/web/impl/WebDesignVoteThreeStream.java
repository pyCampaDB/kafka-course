package com.pycampadb.msvc.broker.stream.web.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pycampadb.msvc.broker.message.WebColorVoteMessage;
import com.pycampadb.msvc.broker.message.WebDesignVoteMessage;
import com.pycampadb.msvc.broker.message.WebLayoutVoteMessage;
import com.pycampadb.msvc.broker.serde.web.WebColorVoteSerde;
import com.pycampadb.msvc.broker.serde.web.WebDesignVoteSerde;
import com.pycampadb.msvc.broker.serde.web.WebLayoutVoteSerde;
import com.pycampadb.msvc.broker.stream.web.WebDesignVoteStream;
import com.pycampadb.msvc.util.web.WebColorLayoutTimestampExtractor;
import com.pycampadb.msvc.util.web.WebColorVoteTimestampExtractor;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Printed;
import org.springframework.beans.factory.annotation.Autowired;

//@Component
public class WebDesignVoteThreeStream implements WebDesignVoteStream {
    private static final String COLOR_VOTE_TOPIC = "t-commodity-web-vote-color";
    private static final String LAYOUT_VOTE_TOPIC = "t-commodity-web-vote-layout";
    private static final String OUTPUT_TOPIC = "t-commodity-web-vote-three-result";
    @Override
    @Autowired
    public void kStreamWebDesignVote(StreamsBuilder builder, ObjectMapper mapper) {
        var stringSerde = Serdes.String();
        var colorSerde = new WebColorVoteSerde(mapper);
        var layoutSerde = new WebLayoutVoteSerde(mapper);
        var designSerde = new WebDesignVoteSerde(mapper);
        var colorExtractor = new WebColorVoteTimestampExtractor();
        var layoutExtractor = new WebColorLayoutTimestampExtractor();

        var colorTable = builder.stream(COLOR_VOTE_TOPIC, Consumed.with(stringSerde, colorSerde, colorExtractor, null))
                .mapValues(WebColorVoteMessage::getColor).toTable();

        var layoutTable = builder.stream(LAYOUT_VOTE_TOPIC, Consumed.with(stringSerde, layoutSerde, layoutExtractor, null))
                .mapValues(WebLayoutVoteMessage::getLayout).toTable();

        var joinTable = colorTable.outerJoin(layoutTable, this::voteJoiner, Materialized.with(stringSerde, designSerde));

        joinTable.toStream().to(OUTPUT_TOPIC);

        joinTable.groupBy(
                (username, votedDesign) -> KeyValue.pair(votedDesign.getColor(), votedDesign.getColor()))
                .count().toStream()
                .print(Printed.<String, Long>toSysOut().withLabel("Vote three - color"));

        joinTable.groupBy(
                        (username, votedDesign) -> KeyValue.pair(votedDesign.getLayout(), votedDesign.getLayout()))
                .count().toStream()
                .print(Printed.<String, Long>toSysOut().withLabel("Vote three - layout"));
    }

    private WebDesignVoteMessage voteJoiner (String color, String layout){
        return new WebDesignVoteMessage(color, layout);
    }
}
