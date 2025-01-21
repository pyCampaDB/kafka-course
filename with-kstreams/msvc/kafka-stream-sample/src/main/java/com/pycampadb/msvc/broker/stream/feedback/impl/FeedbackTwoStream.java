package com.pycampadb.msvc.broker.stream.feedback.impl;

import com.pycampadb.msvc.broker.message.FeedbackMessage;
import com.pycampadb.msvc.broker.stream.feedback.FeedbackStream;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.serializer.JsonSerde;

import java.util.Arrays;
import java.util.Set;

//@Component to FeedbackGoodBadStream
public class FeedbackTwoStream implements FeedbackStream {
    private static final Set<String> GOOD_WORDS = Set.of("happy", "good", "helpful");

    @Override
    @Autowired
    public void kStreamFeedback(StreamsBuilder builder) {
        var stringSerde = Serdes.String();
        var feedbackSerde = new JsonSerde<>(FeedbackMessage.class);

        var goodFeedbackStream = builder.stream("t-commodity-feedback", Consumed.with(stringSerde, feedbackSerde))
                .flatMap(
                        (k,v) ->
                            Arrays.stream(v.getFeedback().toLowerCase().split("\\s+"))  //separa el texto por espacios y los introduce en un arreglo
                                    .map(word -> word.replaceAll("[^a-zA-Z]", ""))
                                    .filter(word -> GOOD_WORDS.contains(word.toLowerCase()))
                                    .distinct()
                                    .map(goodWord -> KeyValue.pair(v.getLocation(), goodWord))
                                    .toList()
                );


        goodFeedbackStream.to("t-commodity-feedback-two-good");
    }

}
