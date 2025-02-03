package com.pycampadb.msvc.command.action.web.impl;

import com.pycampadb.msvc.api.request.web.WebLayoutVoteRequest;
import com.pycampadb.msvc.broker.message.web.WebLayoutVoteMessage;
import com.pycampadb.msvc.broker.producer.web.WebLayoutVoteProducer;
import com.pycampadb.msvc.command.action.web.WebLayoutVoteAction;
import org.springframework.stereotype.Component;

@Component
public class WebLayoutVoteActionImpl implements WebLayoutVoteAction {
    private final WebLayoutVoteProducer producer;

    public WebLayoutVoteActionImpl(WebLayoutVoteProducer producer) {
        this.producer = producer;
    }

    @Override
    public void createWebLayoutVote(WebLayoutVoteRequest request) {
        producer.publishLayoutVote(new WebLayoutVoteMessage(request.getLayout(), request.getUsername(), request.getVoteDateTime()));
    }
}
