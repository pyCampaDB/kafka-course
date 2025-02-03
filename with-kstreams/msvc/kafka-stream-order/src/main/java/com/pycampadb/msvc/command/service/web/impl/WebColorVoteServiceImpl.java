package com.pycampadb.msvc.command.service.web.impl;

import com.pycampadb.msvc.api.request.web.WebColorVoteRequest;
import com.pycampadb.msvc.command.action.web.WebColorVoteAction;
import com.pycampadb.msvc.command.service.web.WebColorVoteService;
import org.springframework.stereotype.Service;

@Service
public class WebColorVoteServiceImpl implements WebColorVoteService {
    private final WebColorVoteAction action;

    public WebColorVoteServiceImpl(WebColorVoteAction action) {
        this.action = action;
    }

    @Override
    public void createWebColorVote(WebColorVoteRequest request) {
        action.createWebColorVote(request);
    }
}
