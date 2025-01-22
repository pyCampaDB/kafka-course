package com.pycampadb.msvc.broker.stream.feedback.rating.configstore;

import com.pycampadb.msvc.broker.message.FeedbackMessage;
import com.pycampadb.msvc.broker.message.FeedbackRatingTwoMessage;
import com.pycampadb.msvc.broker.stream.feedback.rating.modelstore.FeedbackRatingTwoStoreValue;
import org.apache.kafka.streams.processor.api.FixedKeyProcessor;
import org.apache.kafka.streams.processor.api.FixedKeyProcessorContext;
import org.apache.kafka.streams.processor.api.FixedKeyRecord;
import org.apache.kafka.streams.state.KeyValueStore;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class FeedbackRatingTwoFixedKeyProcessor
    implements FixedKeyProcessor<String, FeedbackMessage, FeedbackRatingTwoMessage> {
    private FixedKeyProcessorContext<String, FeedbackRatingTwoMessage> processorContext;
    private KeyValueStore<String, FeedbackRatingTwoStoreValue> ratingStateStore;
    private final String stateStoreName;

    public FeedbackRatingTwoFixedKeyProcessor(String stateStoreName) {
        if (!StringUtils.hasLength(stateStoreName))
            throw new IllegalArgumentException("State store name must not be blank");
        this.stateStoreName = stateStoreName;
    }

    @Override
    public void init(FixedKeyProcessorContext<String, FeedbackRatingTwoMessage> context) {
        this.processorContext=context;
        this.ratingStateStore=this.processorContext.getStateStore(stateStoreName);
    }

    @Override
    public void process(FixedKeyRecord<String, FeedbackMessage> fixedKeyRecord) {
        var originalValue = fixedKeyRecord.value();
        var storeValue = Optional.ofNullable(ratingStateStore.get(originalValue.getLocation()))
                .orElse(new FeedbackRatingTwoStoreValue());
        var ratingMap = Optional.ofNullable(storeValue.getRatingMap()).orElse(new TreeMap<>());
        var currentRatingCount = Optional.ofNullable(ratingMap.get(originalValue.getRating())).orElse(0L);
        var newRatingCount = currentRatingCount + 1;

        ratingMap.put(originalValue.getRating(), newRatingCount);
        storeValue.setRatingMap(ratingMap);
        ratingStateStore.put(originalValue.getLocation(), storeValue);

        var branchRating = new FeedbackRatingTwoMessage();
        branchRating.setLocation(originalValue.getLocation());
        branchRating.setRatingMap(ratingMap);
        branchRating.setAverageRating(calculateAverageRating(ratingMap));

        processorContext.forward(fixedKeyRecord.withValue(branchRating));
    }

    private double calculateAverageRating(Map<Integer, Long> ratingMap) {
        var totalRating = ratingMap.entrySet().stream()
                .mapToDouble(entry -> entry.getKey() * entry.getValue()).sum();
        var totalFeedback = ratingMap.values().stream().mapToLong(Long::longValue).sum();

        return  totalFeedback == 0 ? 0 : Math.round(totalRating/totalFeedback * 10.0)/10.0;
    }


}
