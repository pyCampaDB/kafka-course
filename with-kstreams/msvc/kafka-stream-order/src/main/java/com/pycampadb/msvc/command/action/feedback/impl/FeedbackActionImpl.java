package com.pycampadb.msvc.command.action.feedback.impl;

import com.pycampadb.msvc.api.request.feedback.FeedbackRequest;
import com.pycampadb.msvc.broker.message.feedback.FeedbackMessage;
import com.pycampadb.msvc.broker.producer.feedback.FeedbackProducer;
import com.pycampadb.msvc.command.action.feedback.FeedbackAction;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class FeedbackActionImpl implements FeedbackAction {
    private final FeedbackProducer producer;

    public FeedbackActionImpl(FeedbackProducer producer) {
        this.producer = producer;
    }

    @Override
    public FeedbackMessage convertToFeedbackMessage(FeedbackRequest request) {
        return new FeedbackMessage(
                request.getFeedback(),
                request.getLocation(),
                OffsetDateTime.now(),
                request.getRating()
        );
    }

    @Override
    public void sendToKafka(FeedbackMessage message) {
        producer.publishFeedback(message);
    }
}
