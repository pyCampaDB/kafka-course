package com.pycampadb.msvc.broker.producer;

import com.pycampadb.msvc.broker.message.FeedbackMessage;

public interface FeedbackProducer {
    void publishFeedback(FeedbackMessage message);
}
