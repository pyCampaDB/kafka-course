package com.pycampadb.msvc.broker.stream.customer.preference.impl;

import com.pycampadb.msvc.broker.message.CustomerPreferenceAggregateMessage;
import com.pycampadb.msvc.broker.message.CustomerPreferenceShoppingCartMessage;
import com.pycampadb.msvc.broker.message.CustomerPreferenceWishlistMessage;
import com.pycampadb.msvc.broker.stream.customer.preference.CustomerPreferenceStream;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.kafka.support.serializer.JsonSerde;

//@Configuration to FlashSaleVoteStream
public class CustomerPreferenceOneStream implements CustomerPreferenceStream {
    private static final CustomerPreferenceShoppingCartAggregator SHOPPING_CART_AGGREGATOR = new CustomerPreferenceShoppingCartAggregator();
    private static final CustomerPreferenceWishlistAggregator WISHLIST_AGGREGATOR = new CustomerPreferenceWishlistAggregator();
    private static final String SHOPPING_CART_INPUT_TOPIC = "t-commodity-customer-preference-shopping-cart";
    private static final String WISHLIST_INPUT_TOPIC = "t-commodity-customer-preference-wishlist";
    private static final String OUTPUT_TOPIC = "t-commodity-customer-preference-all";

    @Override
    //@Bean
    public KStream<String, Object> kStreamCustomerPreference(StreamsBuilder builder) {
        var stringSerde = Serdes.String();
        var shoppingCartSerde = new JsonSerde<>(CustomerPreferenceShoppingCartMessage.class);
        var wishlistSerde = new JsonSerde<>(CustomerPreferenceWishlistMessage.class);
        var aggregateSerde = new JsonSerde<>(CustomerPreferenceAggregateMessage.class);

        var groupedShoppingCartStream = builder.stream(SHOPPING_CART_INPUT_TOPIC, Consumed.with(stringSerde, shoppingCartSerde))
                .groupByKey();

        var groupedWishlistStream = builder.stream(WISHLIST_INPUT_TOPIC, Consumed.with(stringSerde, wishlistSerde))
                .groupByKey();

        var customerPreferenceStream = groupedShoppingCartStream.cogroup(SHOPPING_CART_AGGREGATOR)
                .cogroup(groupedWishlistStream, WISHLIST_AGGREGATOR)
                .aggregate(
                        CustomerPreferenceAggregateMessage::new,
                        Materialized.with(stringSerde, aggregateSerde)
                ).toStream();

        customerPreferenceStream.to(OUTPUT_TOPIC, Produced.with(stringSerde, aggregateSerde));
        return builder.stream(OUTPUT_TOPIC);
    }
}
