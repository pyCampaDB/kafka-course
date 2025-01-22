package com.pycampadb.msvc.broker.stream.feedback.rating.impl;

import com.pycampadb.msvc.broker.message.FeedbackMessage;
import com.pycampadb.msvc.broker.message.FeedbackRatingOneMessage;
import com.pycampadb.msvc.broker.stream.feedback.FeedbackStream;
import com.pycampadb.msvc.broker.stream.feedback.rating.configstore.FeedbackRatingOneFixedKeyProcessor;
import com.pycampadb.msvc.broker.stream.feedback.rating.modelstore.FeedbackRatingOneStoreValue;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.state.Stores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.serializer.JsonSerde;

//@Component
public class FeedbackRatingOneStream implements FeedbackStream {

    @Override
    @Autowired
    public void kStreamFeedback(StreamsBuilder builder) {
        var stringSerde = Serdes.String();
        var feedbackSerde = new JsonSerde<>(FeedbackMessage.class);
        var feedbackRatingOneSerde = new JsonSerde<>(FeedbackRatingOneMessage.class);
        var feedbackRatingOneStoreValueSerde = new JsonSerde<>(FeedbackRatingOneStoreValue.class);

        var feedbackRatingStateStoreName = "feedbackRatingOneStateStore";
        var storeSupplier = Stores.inMemoryKeyValueStore(feedbackRatingStateStoreName);
        var storeBuilder = Stores.keyValueStoreBuilder(storeSupplier, stringSerde, feedbackRatingOneStoreValueSerde);

        builder.addStateStore(storeBuilder);
        builder.stream("t-commodity-feedback", Consumed.with(stringSerde, feedbackSerde))
                .processValues(
                        () -> new FeedbackRatingOneFixedKeyProcessor(feedbackRatingStateStoreName),
                        feedbackRatingStateStoreName
                ).to("t-commodity-feedback-rating-one", Produced.with(stringSerde, feedbackRatingOneSerde));

    }
}
