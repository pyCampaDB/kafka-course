package com.pycampadb.msvc.broker.serde.promotion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pycampadb.msvc.broker.message.PromotionMessage;
import com.pycampadb.msvc.broker.serde.CustomJsonDeserializer;
import com.pycampadb.msvc.broker.serde.CustomJsonSerde;
import com.pycampadb.msvc.broker.serde.CustomJsonSerializer;
import org.springframework.beans.factory.annotation.Autowired;

public class PromotionSerde extends CustomJsonSerde<PromotionMessage> {
    @Autowired
    public PromotionSerde(ObjectMapper mapper) {
        super(new CustomJsonSerializer<>(mapper), new CustomJsonDeserializer<>(mapper,PromotionMessage.class));
    }
}
