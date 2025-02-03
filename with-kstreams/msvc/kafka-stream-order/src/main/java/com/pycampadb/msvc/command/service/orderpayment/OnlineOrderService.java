package com.pycampadb.msvc.command.service.orderpayment;

import com.pycampadb.msvc.api.request.orderpayment.OnlineOrderRequest;

public interface OnlineOrderService {
    void createOnlineOrder(OnlineOrderRequest request);
}
