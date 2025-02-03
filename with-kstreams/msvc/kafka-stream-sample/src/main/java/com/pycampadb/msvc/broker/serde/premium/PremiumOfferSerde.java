package com.pycampadb.msvc.broker.serde.premium;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pycampadb.msvc.broker.message.PremiumOfferMessage;
import com.pycampadb.msvc.broker.serde.CustomJsonDeserializer;
import com.pycampadb.msvc.broker.serde.CustomJsonSerde;
import com.pycampadb.msvc.broker.serde.CustomJsonSerializer;
import org.springframework.beans.factory.annotation.Autowired;

public class PremiumOfferSerde extends CustomJsonSerde<PremiumOfferMessage> {
    @Autowired
    public PremiumOfferSerde(ObjectMapper mapper){
        super(new CustomJsonSerializer<>(mapper), new CustomJsonDeserializer<>(mapper, PremiumOfferMessage.class));
    }
}
