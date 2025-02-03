package com.pycampadb.msvc.command.service.commodity.impl;

import com.pycampadb.msvc.api.request.commodity.OrderRequest;
import com.pycampadb.msvc.broker.message.commodity.OrderMessage;
import com.pycampadb.msvc.command.action.commodity.OrderAction;
import com.pycampadb.msvc.command.service.commodity.OrderService;
import com.pycampadb.msvc.entity.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderAction orderAction;

    public OrderServiceImpl(OrderAction orderAction) {
        this.orderAction = orderAction;
    }


    @Override
    public String saveOrder(OrderRequest request) {
        Order orderEntity = orderAction.convertToOrder(request);
        orderAction.saveToDatabase(orderEntity);
        orderEntity.getOrderItems().forEach(item -> {
            OrderMessage orderMessage = orderAction.convertToOrderMessage(orderEntity,item);

            orderAction.sendToKafka(orderMessage);
        });
        return orderEntity.getOrderNumber();
    }
}
