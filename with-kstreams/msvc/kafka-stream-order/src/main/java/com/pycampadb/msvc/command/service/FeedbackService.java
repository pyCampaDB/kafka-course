package com.pycampadb.msvc.command.service;

import com.pycampadb.msvc.api.request.FeedbackRequest;

public interface FeedbackService {
    void createFeedback(FeedbackRequest request);
}
