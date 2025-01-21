package com.pycampadb.msvc.command.action.impl;

import com.pycampadb.msvc.api.request.OrderRequest;
import com.pycampadb.msvc.broker.message.OrderMessage;
import com.pycampadb.msvc.broker.producer.OrderProducer;
import com.pycampadb.msvc.command.action.OrderAction;
import com.pycampadb.msvc.entity.Order;
import com.pycampadb.msvc.entity.OrderItem;
import com.pycampadb.msvc.repository.OrderItemRepository;
import com.pycampadb.msvc.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.UUID;

@Component
public class OrderActionImpl implements OrderAction {
    private final OrderProducer orderProducer;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderActionImpl(OrderProducer orderProducer, OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.orderProducer = orderProducer;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public Order convertToOrder(OrderRequest request) {
        var order = new Order();
        order.setOrderLocation(request.getOrderLocation());
        order.setCreditCardNumber(request.getCreditCardNumber());
        order.setOrderDateTime(OffsetDateTime.now());
        order.setOrderNumber(UUID.randomUUID().toString().toUpperCase());

        var orderItems = request.getItems().stream().map(
                item -> {
                    var orderItem = new OrderItem();
                    orderItem.setItemName(item.getItemName());
                    orderItem.setQuantity(item.getQuantity());
                    orderItem.setPrice(item.getPrice());
                    orderItem.setOrder(order);
                    return orderItem;
                }
        ).toList();

        order.setOrderItems(orderItems);
        return order;
    }

    @Override
    public void saveToDatabase(Order orderEntity) {
        orderRepository.save(orderEntity);
        orderEntity.getOrderItems().forEach(orderItemRepository::save);
    }

    @Override
    public OrderMessage convertToOrderMessage(OrderItem item) {
        var orderMessage = new OrderMessage();

        orderMessage.setItemName(item.getItemName());
        orderMessage.setPrice(item.getPrice());
        orderMessage.setQuantity(item.getQuantity());
        orderMessage.setOrderDateTime(item.getOrder().getOrderDateTime());
        orderMessage.setOrderLocation(item.getOrder().getOrderLocation());

        return orderMessage;
    }

    @Override
    public void sendToKafka(OrderMessage orderMessage) {
        orderProducer.sendOrder(orderMessage);
    }
}
