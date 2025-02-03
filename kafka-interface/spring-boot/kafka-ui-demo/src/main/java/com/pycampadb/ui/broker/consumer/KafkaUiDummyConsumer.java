package com.pycampadb.ui.broker.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaUiDummyConsumer {
    public static final String TOPIC_ONE = "t-ui-demo-one";
    public static final String TOPIC_TWO = "t-ui-demo-two";
    private static final Logger log = LoggerFactory.getLogger(KafkaUiDummyConsumer.class);

    @KafkaListener(topics = TOPIC_ONE, concurrency = "2")
    public void listenTopicOne(ConsumerRecord<String, String> consumerRecord){
        log.info("{}", consumerRecord.value());
    }

    @KafkaListener(topics = TOPIC_TWO, concurrency = "1")
    public void listenTopicTwo(ConsumerRecord<String, String> consumerRecord){
        log.info("{}", consumerRecord.value());
    }
}
