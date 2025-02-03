package com.pycampadb.msvc.command.service.feedback;

import com.pycampadb.msvc.api.request.feedback.FeedbackRequest;

public interface FeedbackService {
    void createFeedback(FeedbackRequest request);
}
