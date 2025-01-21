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

import java.util.Arrays;
import java.util.Set;

//@Component to FeedbackGoodBadByRatingStream
public class FeedbackGoodBadStream implements FeedbackStream {
    private static final Set<String> GOOD_WORDS = Set.of("happy", "good", "helpful");
    private static final Set<String> BAD_WORDS = Set.of("unhappy", "bad", "poor", "unhelpful");

    @Override
    @Autowired
    public void kStreamFeedback(StreamsBuilder builder) {
        var stringSerde = Serdes.String();
        var feedbackSerde = new JsonSerde<>(FeedbackMessage.class);

        builder.stream("t-commodity-feedback", Consumed.with(stringSerde, feedbackSerde))
                .split()
                .branch(predicateGoodWords(),
                        Branched.<String, FeedbackMessage>withConsumer(
                                ks -> ks.to("t-commodity-feedback-three-good")
                        )
                ).defaultBranch(
                        Branched.<String, FeedbackMessage>withConsumer(
                                ks -> ks.to("t-commodity-feedback-three-bad")
                        )
                );


    }

    private Predicate<String, FeedbackMessage> predicateGoodWords(){
        return (k, v) -> {
            var goodStream = Arrays.stream(v.getFeedback().split("\\s"))
                    .map(word -> word.replaceAll("[^a-zA-Z]", ""))
                    .filter(word -> GOOD_WORDS.contains(word.toLowerCase()));

            var badStream = Arrays.stream(v.getFeedback().split("\\s"))
                    .map(word -> word.replaceAll("[^a-zA-Z]", ""))
                    .filter(word -> BAD_WORDS.contains(word.toLowerCase()));

            return goodStream.count() > badStream.count();
        };
    }
}
