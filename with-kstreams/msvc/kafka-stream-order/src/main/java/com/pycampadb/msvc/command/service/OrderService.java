package com.pycampadb.msvc.command.service;

import com.pycampadb.msvc.api.request.OrderRequest;

public interface OrderService {
    String saveOrder(OrderRequest request);
}
