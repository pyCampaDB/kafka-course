package com.pycampadb.msvc.command.service.impl;

import com.pycampadb.msvc.api.request.FeedbackRequest;
import com.pycampadb.msvc.command.action.FeedbackAction;
import com.pycampadb.msvc.command.service.FeedbackService;
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
