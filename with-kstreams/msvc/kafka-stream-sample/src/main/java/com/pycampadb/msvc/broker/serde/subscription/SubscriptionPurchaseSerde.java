package com.pycampadb.msvc.broker.serde.subscription;

import com.fasterxml.jackson.databind.ObjectMapper;
    import com.pycampadb.msvc.broker.message.SubscriptionPurchaseMessage;
import com.pycampadb.msvc.broker.serde.CustomJsonDeserializer;
import com.pycampadb.msvc.broker.serde.CustomJsonSerde;
import com.pycampadb.msvc.broker.serde.CustomJsonSerializer;
import org.springframework.beans.factory.annotation.Autowired;

public class SubscriptionPurchaseSerde extends CustomJsonSerde<SubscriptionPurchaseMessage> {
    @Autowired
    public SubscriptionPurchaseSerde(ObjectMapper mapper){
        super(new CustomJsonSerializer<>(mapper), new CustomJsonDeserializer<>(mapper, SubscriptionPurchaseMessage.class));
    }
}
