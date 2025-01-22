package com.pycampadb.msvc.broker.stream.feedback.impl;

import com.pycampadb.msvc.broker.message.FeedbackMessage;
import com.pycampadb.msvc.broker.stream.feedback.FeedbackStream;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Branched;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KeyValueMapper;
import org.apache.kafka.streams.kstream.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.serializer.JsonSerde;

import java.util.Arrays;
import java.util.Set;

//@Component
public class FeedbackFourStream implements FeedbackStream {
    private static final Set<String> GOOD_WORDS = Set.of("happy", "good", "helpful","smile");
    private static final Set<String> BAD_WORDS = Set.of("unhappy", "bad", "poor", "unhelpful", "sad");

    @Override
    @Autowired
    public void kStreamFeedback(StreamsBuilder builder) {
        var stringSerde = Serdes.String();
        var feedbackSerde = new JsonSerde<>(FeedbackMessage.class);

        builder.stream("t-commodity-feedback", Consumed.with(stringSerde, feedbackSerde))
                .flatMap(splitWords())
                .split()
                .branch(isGoodWord(),
                        Branched.withConsumer(
                                ks -> {
                                    ks.to("t-commodity-feedback-four-good");
                                    ks.groupByKey() //KGroupedStream
                                            .count(). //KTable
                                            toStream().
                                            to("t-commodity-feedback-four-good-count");
                                }
                        )
                ).branch(isBadWord(),
                        Branched.withConsumer(
                                ks -> {
                                    ks.to("t-commodity-feedback-four-bad");
                                    ks.groupByKey() //KGroupedStream
                                            .count().
                                            toStream().
                                            to("t-commodity-feedback-four-bad-count");
                                }
                        )
                );


    }

    private Predicate<String, String> isGoodWord(){
        return (k, v) -> GOOD_WORDS.contains(v);
    }

    private Predicate<String, String> isBadWord(){
        return (k, v) -> BAD_WORDS.contains(v);
    }


    private KeyValueMapper<String, FeedbackMessage, Iterable<KeyValue<String, String>>> splitWords(){
        return (k,v) ->
                Arrays.stream(v.getFeedback().toLowerCase().split("\\s+"))  //separa el texto por espacios y los introduce en un arreglo
                        .map(word -> word.replaceAll("[^a-zA-Z]", ""))
                        .distinct()
                        .map(goodWord -> KeyValue.pair(v.getLocation(), goodWord))
                        .toList();
    }

}
