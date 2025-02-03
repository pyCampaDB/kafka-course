package com.pycampadb.msvc.command.service.web.impl;

import com.pycampadb.msvc.api.request.web.WebLayoutVoteRequest;
import com.pycampadb.msvc.command.action.web.WebLayoutVoteAction;
import com.pycampadb.msvc.command.service.web.WebLayoutVoteService;
import org.springframework.stereotype.Service;

@Service
public class WebLayoutVoteServiceImpl implements WebLayoutVoteService {
    private final WebLayoutVoteAction action;

    public WebLayoutVoteServiceImpl(WebLayoutVoteAction action) {
        this.action = action;
    }

    @Override
    public void createWebLayoutVote(WebLayoutVoteRequest request) {
        action.createWebLayoutVote(request);
    }
}
