package com.pycampadb.msvc.command.action.commodity;

import com.pycampadb.msvc.api.request.commodity.OrderRequest;
import com.pycampadb.msvc.broker.message.commodity.OrderMessage;
import com.pycampadb.msvc.entity.Order;
import com.pycampadb.msvc.entity.OrderItem;

public interface OrderAction {
    Order convertToOrder(OrderRequest request);

    void saveToDatabase(Order orderEntity);

    OrderMessage convertToOrderMessage(Order orderEntity, OrderItem item);

    void sendToKafka(OrderMessage orderMessage);
}
