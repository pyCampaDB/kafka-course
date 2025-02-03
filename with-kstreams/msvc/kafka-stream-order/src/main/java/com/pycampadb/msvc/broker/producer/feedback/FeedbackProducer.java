package com.pycampadb.msvc.broker.producer.feedback;

import com.pycampadb.msvc.broker.message.feedback.FeedbackMessage;

public interface FeedbackProducer {
    void publishFeedback(FeedbackMessage message);
}
