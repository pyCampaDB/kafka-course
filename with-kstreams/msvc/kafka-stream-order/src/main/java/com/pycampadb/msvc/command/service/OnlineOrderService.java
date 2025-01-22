package com.pycampadb.msvc.command.service;

import com.pycampadb.msvc.api.request.OnlineOrderRequest;

public interface OnlineOrderService {
    void createOnlineOrder(OnlineOrderRequest request);
}
