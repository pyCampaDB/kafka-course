package com.pycampadb.msvc.broker.message;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.OffsetDateTime;

public class FeedbackMessage {
    private String feedback;
    private String location;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private OffsetDateTime feedbackDateTime;
    private int rating;

    public FeedbackMessage() {
    }

    public FeedbackMessage(String feedback, String location, OffsetDateTime feedbackDateTime, int rating) {
        this.feedback = feedback;
        this.location = location;
        this.feedbackDateTime = feedbackDateTime;
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public OffsetDateTime getFeedbackDateTime() {
        return feedbackDateTime;
    }

    public void setFeedbackDateTime(OffsetDateTime feedbackDateTime) {
        this.feedbackDateTime = feedbackDateTime;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "FeedbackMessage{" +
                "feedback='" + feedback + '\'' +
                ", location='" + location + '\'' +
                ", feedbackDateTime=" + feedbackDateTime +
                ", rating=" + rating +
                '}';
    }
}
