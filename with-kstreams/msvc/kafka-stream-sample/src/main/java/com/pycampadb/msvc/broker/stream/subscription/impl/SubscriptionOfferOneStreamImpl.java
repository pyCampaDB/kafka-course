package com.pycampadb.msvc.broker.stream.subscription.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pycampadb.msvc.broker.message.SubscriptionOfferMessage;
import com.pycampadb.msvc.broker.message.SubscriptionPurchaseMessage;
import com.pycampadb.msvc.broker.message.SubscriptionUserMessage;
import com.pycampadb.msvc.broker.serde.subscription.SubscriptionOfferSerde;
import com.pycampadb.msvc.broker.serde.subscription.SubscriptionPurchaseSerde;
import com.pycampadb.msvc.broker.serde.subscription.SubscriptionUserSerde;
import com.pycampadb.msvc.broker.stream.subscription.SubscriptionOfferStream;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Joined;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;

//@Component
public class SubscriptionOfferOneStreamImpl implements SubscriptionOfferStream {
    private static final String USER_TOPIC = "t-commodity-subscription-user";
    private static final String PURCHASE_TOPIC = "t-commodity-subscription-purchase";
    private static final String OFFER_TOPIC = "t-commodity-subscription-offer-one";

    @Override
    @Autowired
    public void kStreamSubscriptionOffer(StreamsBuilder builder, ObjectMapper mapper) {
        var stringSerde = Serdes.String();
        var offerSerde = new SubscriptionOfferSerde(mapper);
        var userSerde = new SubscriptionUserSerde(mapper);
        var purchaseSerde = new SubscriptionPurchaseSerde(mapper);
        var joined = Joined.with(stringSerde, purchaseSerde, userSerde);

        var purchaseStream = builder.stream(PURCHASE_TOPIC, Consumed.with(stringSerde, purchaseSerde));

        var userTable = builder.table(USER_TOPIC, Consumed.with(stringSerde, userSerde));

        purchaseStream.join(userTable, this::joiner, joined).to(OFFER_TOPIC, Produced.with(stringSerde, offerSerde));
    }

    private SubscriptionOfferMessage joiner (SubscriptionPurchaseMessage purchase, SubscriptionUserMessage user){
        return new SubscriptionOfferMessage(
                purchase.getUsername(),
                user.getDuration(),
                purchase.getSubscriptionNumber()
        );
    }
}
