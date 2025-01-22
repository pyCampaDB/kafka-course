package com.pycampadb.msvc.broker.stream.feedback.rating.configstore;

import com.pycampadb.msvc.broker.message.FeedbackMessage;
import com.pycampadb.msvc.broker.message.FeedbackRatingOneMessage;
import com.pycampadb.msvc.broker.stream.feedback.rating.modelstore.FeedbackRatingOneStoreValue;
import org.apache.kafka.streams.processor.api.FixedKeyProcessor;
import org.apache.kafka.streams.processor.api.FixedKeyProcessorContext;
import org.apache.kafka.streams.processor.api.FixedKeyRecord;
import org.apache.kafka.streams.state.KeyValueStore;
import org.springframework.util.StringUtils;

import java.util.Optional;

public class FeedbackRatingOneFixedKeyProcessor
        implements FixedKeyProcessor<String, FeedbackMessage, FeedbackRatingOneMessage> {

    private FixedKeyProcessorContext<String, FeedbackRatingOneMessage> processorContext;
    private final String stateStoreName;
    private KeyValueStore<String, FeedbackRatingOneStoreValue> ratingStateStore;

    public FeedbackRatingOneFixedKeyProcessor(String stateStoreName) {
        if (!StringUtils.hasLength(stateStoreName))
            throw new IllegalArgumentException("State store name must not be empty");
        this.stateStoreName = stateStoreName;
    }

    @Override
    public void init(FixedKeyProcessorContext<String, FeedbackRatingOneMessage> context) {
        this.processorContext=context;
        this.ratingStateStore=this.processorContext.getStateStore(stateStoreName);
    }

    @Override
    public void process(FixedKeyRecord<String, FeedbackMessage> fixedKeyRecord) {
        var originalValue = fixedKeyRecord.value();
        var storeValue = Optional.ofNullable(ratingStateStore.get(originalValue.getLocation()))
                .orElse(new FeedbackRatingOneStoreValue());
        var newSumRating = storeValue.getSumRating() + originalValue.getRating();
        var newCountRating = storeValue.getCountRating() + 1;

        storeValue.setSumRating(newSumRating);
        storeValue.setCountRating(newCountRating);

        ratingStateStore.put(originalValue.getLocation(), storeValue);

        //new value to be forwarded (nuevo valor a reenviar)
        var branchRating = new FeedbackRatingOneMessage();
        branchRating.setLocation(originalValue.getLocation());
        double averageRating = Math.round((double) newSumRating/newCountRating * 10.0) / 10.0;
        branchRating.setAverageRating(averageRating);
        processorContext.forward(fixedKeyRecord.withValue(branchRating));
    }
}
