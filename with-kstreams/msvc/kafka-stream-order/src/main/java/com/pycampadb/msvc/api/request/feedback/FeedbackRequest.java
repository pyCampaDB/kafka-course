package com.pycampadb.msvc.api.request.feedback;

public class FeedbackRequest {
    private String feedback;
    private String location;
    private int rating;

    public FeedbackRequest() {
    }

    public FeedbackRequest(String feedback, String location, int rating) {
        this.feedback = feedback;
        this.location = location;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "FeedbackRequest{" +
                "feedback='" + feedback + '\'' +
                ", location='" + location + '\'' +
                ", rate=" + rating +
                '}';
    }
}
