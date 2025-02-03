package com.pycampadb.msvc.command.service.commodity;

import com.pycampadb.msvc.api.request.commodity.OrderRequest;

public interface OrderService {
    String saveOrder(OrderRequest request);
}
