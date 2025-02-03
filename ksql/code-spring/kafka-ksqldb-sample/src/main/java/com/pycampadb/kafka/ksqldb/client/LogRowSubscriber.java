package com.pycampadb.kafka.ksqldb.client;

import io.confluent.ksql.api.client.Row;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogRowSubscriber implements Subscriber<Row> {
    private static final Logger log = LoggerFactory.getLogger(LogRowSubscriber.class);
    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription s) {
        log.info("onSubscribe(), starting subscription");
        this.subscription = s;

        this.subscription.request(1);
    }

    @Override
    public void onNext(Row row) {
        log.info("onNext(), row: {}", row);
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable t) {
        log.error("onError(), error: {}", t.getMessage(), t);
    }

    @Override
    public void onComplete() {
        log.info("onComplete(), all rows are consumed, subscription ended");
    }
}
