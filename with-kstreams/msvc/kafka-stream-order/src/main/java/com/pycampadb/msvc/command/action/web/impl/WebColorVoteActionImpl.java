package com.pycampadb.msvc.command.action.web.impl;

import com.pycampadb.msvc.api.request.web.WebColorVoteRequest;
import com.pycampadb.msvc.broker.message.web.WebColorVoteMessage;
import com.pycampadb.msvc.broker.producer.web.WebColorVoteProducer;
import com.pycampadb.msvc.command.action.web.WebColorVoteAction;
import org.springframework.stereotype.Component;

@Component
public class WebColorVoteActionImpl implements WebColorVoteAction {
    private final WebColorVoteProducer producer;

    public WebColorVoteActionImpl(WebColorVoteProducer producer) {
        this.producer = producer;
    }

    @Override
    public void createWebColorVote(WebColorVoteRequest request) {
        producer.publishColorVote(new WebColorVoteMessage(request.getColor(), request.getUsername(), request.getVoteDateTime()));
    }
}
