package com.pycampadb.kafka.broker.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pycampadb.kafka.broker.message.CdcMessage;
import com.pycampadb.kafka.broker.message.marketing.MarketingPromotionMessage;
import com.pycampadb.kafka.broker.message.marketing.MarketingSalesMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MarketingCdcConsumer {
    private static final Logger log = LoggerFactory.getLogger(MarketingCdcConsumer.class);

    private final ObjectMapper mapper;

    public MarketingCdcConsumer(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @KafkaListener(topics = "t-cdc-marketing.public.mkt_promotions")
    public void listenPromotion(String message) throws JsonProcessingException {
        var promotion = mapper.readValue(message, new TypeReference<CdcMessage<MarketingPromotionMessage>>() {
        });
        log.info("Processing promotion: {}", promotion);
    }

    @KafkaListener(topics = "t-cdc-marketing.public.mkt_sales")
    public void listenSales(String message) throws JsonProcessingException {
        var sales = mapper.readValue(message, new TypeReference<CdcMessage<MarketingSalesMessage>>() {
        });
        log.info("Processing sales: {}", sales);
    }
}
