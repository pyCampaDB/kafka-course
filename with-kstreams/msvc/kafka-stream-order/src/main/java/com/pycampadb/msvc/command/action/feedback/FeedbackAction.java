package com.pycampadb.msvc.command.action.feedback;

import com.pycampadb.msvc.api.request.feedback.FeedbackRequest;
import com.pycampadb.msvc.broker.message.feedback.FeedbackMessage;

public interface FeedbackAction {
    FeedbackMessage convertToFeedbackMessage(FeedbackRequest request);
    void sendToKafka(FeedbackMessage message);
}
