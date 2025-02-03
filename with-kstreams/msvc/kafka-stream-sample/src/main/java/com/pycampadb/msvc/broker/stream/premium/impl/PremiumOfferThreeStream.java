package com.pycampadb.msvc.broker.stream.premium.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pycampadb.msvc.broker.message.PremiumOfferMessage;
import com.pycampadb.msvc.broker.message.PremiumPurchaseMessage;
import com.pycampadb.msvc.broker.message.PremiumUserMessage;
import com.pycampadb.msvc.broker.serde.premium.PremiumOfferSerde;
import com.pycampadb.msvc.broker.serde.premium.PremiumPurchaseSerde;
import com.pycampadb.msvc.broker.serde.premium.PremiumUserSerde;
import com.pycampadb.msvc.broker.stream.premium.PremiumOfferStream;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//@Component
public class PremiumOfferThreeStream implements PremiumOfferStream {
    private static final String USER_TOPIC = "t-commodity-premium-user";
    private static final String PURCHASE_TOPIC = "t-commodity-premium-purchase";
    private static final String FILTERED_USER_TOPIC = USER_TOPIC + "-filtered";
    private static final String OFFER_TOPIC = "t-commodity-premium-offer-two";
    private static final List<String> LEVELS = List.of("gold", "diamond");

    @Override
    @Autowired
    public void kStreamPremiumOffer(StreamsBuilder builder, ObjectMapper mapper) {
        var stringSerde = Serdes.String();
        var purchaseSerde = new PremiumPurchaseSerde(mapper);
        var userSerde = new PremiumUserSerde(mapper);
        var offerSerde = new PremiumOfferSerde(mapper);

        var purchaseStream = builder.stream(PURCHASE_TOPIC, Consumed.with(stringSerde, purchaseSerde))
                .selectKey((k, v) -> v.getUsername());

        builder.stream(USER_TOPIC, Consumed.with(stringSerde, userSerde))
                .filter((k, v) -> LEVELS.contains(v.getLevel().toLowerCase()))
                .to(FILTERED_USER_TOPIC, Produced.with(stringSerde, userSerde));

        var userTable = builder.globalTable(FILTERED_USER_TOPIC, Consumed.with(stringSerde, userSerde));

        var offerStream = purchaseStream.join(
                userTable,
                (key, value) -> key, //(key, value) -> value.getUsername()
                this::joiner
        );

        offerStream.to(OFFER_TOPIC, Produced.with(stringSerde, offerSerde));

    }

    private PremiumOfferMessage joiner (PremiumPurchaseMessage purchase, PremiumUserMessage user){
        var result = new PremiumOfferMessage();
        result.setUsername(purchase.getUsername());
        result.setPurchaseNumber(purchase.getPurchaseNumber());

        if (user!=null)
            result.setLevel(user.getLevel());

        return result;
    }
}
