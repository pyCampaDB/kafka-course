package com.pycampadb.msvc.command.service.impl;

import com.pycampadb.msvc.api.request.OrderRequest;
import com.pycampadb.msvc.broker.message.OrderMessage;
import com.pycampadb.msvc.command.action.OrderAction;
import com.pycampadb.msvc.command.service.OrderService;
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
