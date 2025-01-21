package com.pycampadb.msvc.broker.stream.feedback.impl;

import com.pycampadb.msvc.broker.message.FeedbackMessage;
import com.pycampadb.msvc.broker.stream.feedback.FeedbackStream;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Branched;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.serializer.JsonSerde;

//@Component to FeedbackGoodBadWordsStream
public class FeedbackGoodBadByRatingStream implements FeedbackStream {

    @Override
    @Autowired
    public void kStreamFeedback(StreamsBuilder builder) {
        var stringSerde = Serdes.String();
        var feedbackSerde = new JsonSerde<>(FeedbackMessage.class);

        builder.stream("t-commodity-feedback", Consumed.with(stringSerde, feedbackSerde))
                .split()
                .branch(predicateGoodRate(),
                        Branched.<String, FeedbackMessage>withConsumer(
                                ks -> ks.to("t-commodity-feedback-three-good")
                        )
                ).defaultBranch(
                        Branched.<String, FeedbackMessage>withConsumer(
                                ks -> ks.to("t-commodity-feedback-three-bad")
                        )
                );


    }


    private Predicate<String, FeedbackMessage> predicateGoodRate(){
        return (k, v) -> v.getRating()>=3;
    }


}
