package com.pycampadb.msvc.broker.stream.feedback.rating.modelstore;

public class FeedbackRatingOneStoreValue {
    private long countRating;
    private long sumRating;

    public FeedbackRatingOneStoreValue() {
    }

    public FeedbackRatingOneStoreValue(long countRating, long sumRating) {
        this.countRating = countRating;
        this.sumRating = sumRating;
    }

    public long getCountRating() {
        return countRating;
    }

    public void setCountRating(long countRating) {
        this.countRating = countRating;
    }

    public long getSumRating() {
        return sumRating;
    }

    public void setSumRating(long sumRating) {
        this.sumRating = sumRating;
    }

    @Override
    public String toString() {
        return "FeedbackRatingOneStoreValue{" +
                "countRating=" + countRating +
                ", sumRating=" + sumRating +
                '}';
    }
}
