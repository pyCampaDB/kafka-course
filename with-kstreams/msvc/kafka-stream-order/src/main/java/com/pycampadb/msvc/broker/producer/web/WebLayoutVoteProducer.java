package com.pycampadb.msvc.broker.producer.web;

import com.pycampadb.msvc.broker.message.web.WebLayoutVoteMessage;

public interface WebLayoutVoteProducer {
    void publishLayoutVote(WebLayoutVoteMessage message);
}
