package com.pycampadb.msvc.command.service.feedback.impl;

import com.pycampadb.msvc.api.request.feedback.FeedbackRequest;
import com.pycampadb.msvc.command.action.feedback.FeedbackAction;
import com.pycampadb.msvc.command.service.feedback.FeedbackService;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackAction action;

    public FeedbackServiceImpl(FeedbackAction action) {
        this.action = action;
    }

    @Override
    public void createFeedback(FeedbackRequest request) {
        var message = action.convertToFeedbackMessage(request);
        action.sendToKafka(message);
    }
}
