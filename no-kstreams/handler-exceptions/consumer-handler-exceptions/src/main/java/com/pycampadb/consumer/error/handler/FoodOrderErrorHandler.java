package com.pycampadb.consumer.error.handler;

import org.apache.kafka.clients.consumer.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service(value = "myFoodOrderErrorHandler")
public class FoodOrderErrorHandler implements ConsumerAwareListenerErrorHandler {
    private static final Logger log = LoggerFactory.getLogger(FoodOrderErrorHandler.class);

    @SuppressWarnings("null")
    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception, Consumer<?, ?> consumer) {
        log.warn(
                "FoodOrder error, sending to Elasticsearch (example): {}, because: {}",
                message.getPayload(),
                exception.getMessage()
        );
        if (exception.getCause() instanceof RuntimeException)
            throw exception;

        return null;
    }
}
