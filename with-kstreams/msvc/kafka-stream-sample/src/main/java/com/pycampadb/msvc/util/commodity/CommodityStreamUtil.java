package com.pycampadb.msvc.util.commodity;

import com.pycampadb.msvc.broker.message.OrderMessage;
import com.pycampadb.msvc.broker.message.OrderPatternMessage;
import com.pycampadb.msvc.broker.message.OrderRewardMessage;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KeyValueMapper;
import org.apache.kafka.streams.kstream.Predicate;

import java.time.OffsetDateTime;
import java.util.Base64;

public class CommodityStreamUtil {
    private CommodityStreamUtil(){
        throw new IllegalArgumentException("Utility class!");
    }
    public static OrderMessage maskCreditCardNumber(OrderMessage message){
        String creditCardNumber = message.getCreditCardNumber();
        String maskedCreditCardNumber = null;
        if (creditCardNumber != null)
            maskedCreditCardNumber = "****-****-****-" + creditCardNumber.substring(creditCardNumber.length() - 4);
        else
            maskedCreditCardNumber = "****-****-****-****";
        return new OrderMessage(
                message.getOrderLocation(),
                message.getOrderNumber(),
                message.getOrderDateTime(),
                maskedCreditCardNumber,
                message.getItemName(),
                message.getPrice(),
                message.getQuantity()
        );
    }

    public static OrderPatternMessage convertToPatternMessage (OrderMessage orderMessage){
        String itemName = orderMessage.getItemName();
        long totalItemAmount = (long) orderMessage.getPrice() * orderMessage.getQuantity();
        OffsetDateTime orderDateTime = orderMessage.getOrderDateTime();
        String orderLocation = orderMessage.getOrderLocation();
        String orderNumber = orderMessage.getOrderNumber();

        return new OrderPatternMessage(itemName, totalItemAmount, orderDateTime, orderLocation, orderNumber);
    }

    public static OrderRewardMessage convertToOrderRewardMessage(OrderMessage orderMessage){
        var orderLocation = orderMessage.getOrderLocation();
        var orderNumber = orderMessage.getOrderNumber();
        var orderDateTime = orderMessage.getOrderDateTime();
        var itemName = orderMessage.getItemName();
        var price = orderMessage.getPrice();
        var quantity = orderMessage.getQuantity();

        return new OrderRewardMessage(orderLocation, orderNumber, orderDateTime, itemName, price, quantity);
    }

    public static Predicate<String, OrderMessage> isLargeQuantity(){
        return (key, orderMessage) -> orderMessage.getQuantity() > 200;
    }

    public static Predicate<String, OrderPatternMessage> isPlasticItem(){
        return (key, orderPatternMessage) ->
                orderPatternMessage.getItemName().toLowerCase().startsWith("plastic");
    }

    public static Predicate<String, OrderMessage> isCheap() {
        return (key, orderMessage) -> orderMessage.getPrice() < 100;
    }

    public static KeyValueMapper<String, OrderMessage, String> generateStorageKey(){
        return (key, orderMessage) -> {
            if (orderMessage.getOrderNumber()!=null)
                return Base64.getEncoder().encodeToString(orderMessage.getOrderNumber().getBytes());
            return null;
        };
    }

    public static KeyValueMapper<String, OrderMessage, KeyValue<String, OrderRewardMessage>> mapToOrderRewardChangeKey(){
        return (key, orderMessage) -> KeyValue.pair(
                orderMessage.getOrderLocation(), convertToOrderRewardMessage(orderMessage)
        );
    }
}
