package com.pycampadb.msvc.broker.stream.feedback.rating.modelstore;

import java.util.Map;

public class FeedbackRatingTwoStoreValue {
    private Map<Integer, Long> ratingMap;

    public FeedbackRatingTwoStoreValue() {
    }

    public FeedbackRatingTwoStoreValue(Map<Integer, Long> ratingMap) {
        this.ratingMap = ratingMap;
    }

    public Map<Integer, Long> getRatingMap() {
        return ratingMap;
    }

    public void setRatingMap(Map<Integer, Long> ratingMap) {
        this.ratingMap = ratingMap;
    }

    @Override
    public String toString() {
        return "FeedbackRatingTwoStoreValue{" +
                "ratingMap=" + ratingMap +
                '}';
    }
}
