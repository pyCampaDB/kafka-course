package com.pycampadb.msvc.broker.producer.web;

import com.pycampadb.msvc.broker.message.web.WebColorVoteMessage;

public interface WebColorVoteProducer {
    void publishColorVote(WebColorVoteMessage message);
}
