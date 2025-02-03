package com.pycampadb.msvc.broker.serde.subscription;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pycampadb.msvc.broker.message.SubscriptionOfferMessage;
import com.pycampadb.msvc.broker.serde.CustomJsonDeserializer;
import com.pycampadb.msvc.broker.serde.CustomJsonSerde;
import com.pycampadb.msvc.broker.serde.CustomJsonSerializer;
import org.springframework.beans.factory.annotation.Autowired;

public class SubscriptionOfferSerde extends CustomJsonSerde<SubscriptionOfferMessage> {
    @Autowired
    public SubscriptionOfferSerde(ObjectMapper mapper){
        super(new CustomJsonSerializer<>(mapper), new CustomJsonDeserializer<>(mapper, SubscriptionOfferMessage.class));
    }
}
