package com.pycampadb.msvc.command.action;

import com.pycampadb.msvc.api.request.FeedbackRequest;
import com.pycampadb.msvc.broker.message.FeedbackMessage;

public interface FeedbackAction {
    FeedbackMessage convertToFeedbackMessage(FeedbackRequest request);
    void sendToKafka(FeedbackMessage message);
}
