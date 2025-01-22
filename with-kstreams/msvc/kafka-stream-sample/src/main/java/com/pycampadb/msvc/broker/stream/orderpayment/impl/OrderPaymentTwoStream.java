package com.pycampadb.msvc.broker.stream.orderpayment.impl;

import com.pycampadb.msvc.broker.message.OnlineOrderMessage;
import com.pycampadb.msvc.broker.message.OnlineOrderPaymentMessage;
import com.pycampadb.msvc.broker.message.OnlinePaymentMessage;
import com.pycampadb.msvc.broker.stream.orderpayment.OrderPaymentStream;
import com.pycampadb.msvc.util.OnlineOrderTimestampExtractor;
import com.pycampadb.msvc.util.OnlinePaymentTimestampExtractor;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.JoinWindows;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.kstream.StreamJoined;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.serializer.JsonSerde;

import java.time.Duration;

//@Component
public class OrderPaymentTwoStream implements OrderPaymentStream {
    private static final String ORDER_TOPIC = "t-commodity-online-order";
    private static final String PAYMENT_TOPIC = "t-commodity-online-payment";
    private static final String OUTPUT_TOPIC = "t-commodity-join-order-payment-two";

    @Override
    @Autowired
    public void kStreamOrderPayment(StreamsBuilder builder) {
        var stringSerde = Serdes.String();
        var orderSerde = new JsonSerde<>(OnlineOrderMessage.class);
        var paymentSerde = new JsonSerde<>(OnlinePaymentMessage.class);
        var orderPaymentSerde = new JsonSerde<>(OnlineOrderPaymentMessage.class);

        var joinWindow = JoinWindows.ofTimeDifferenceWithNoGrace(Duration.ofHours(1L));
        var streamJoined = StreamJoined.with(stringSerde, orderSerde, paymentSerde);

        var orderStream = builder.stream(
                ORDER_TOPIC,
                Consumed.with(stringSerde, orderSerde, new OnlineOrderTimestampExtractor(), null)
        );

        var paymentStream = builder.stream(
                PAYMENT_TOPIC,
                Consumed.with(stringSerde, paymentSerde, new OnlinePaymentTimestampExtractor(), null)
        );

        orderStream.leftJoin(
                        paymentStream, //Right stream
                        this::joinOrderPayment, //Joined Stream
                        joinWindow, //JoinWindow
                        streamJoined //StreamJoined
                )
                .to(OUTPUT_TOPIC, Produced.with(stringSerde, orderPaymentSerde));

    }

    private OnlineOrderPaymentMessage joinOrderPayment (OnlineOrderMessage order, OnlinePaymentMessage payment){
        var result = new OnlineOrderPaymentMessage();
        result.setOnlineOrderNumber(order.getOnlineOrderNumber());
        result.setOrderDateTime(order.getOrderDateTime());
        result.setTotalAmount(order.getTotalAmount());
        result.setUsername(order.getUsername());

        if (payment != null) {
            result.setPaymentDateTime(payment.getPaymentDateTime());
            result.setPaymentMethod(payment.getPaymentMethod());
            result.setPaymentNumber(payment.getPaymentNumber());
        }
        return result;
    }
}
