package com.pycampadb.msvc.command.service.discount;

import com.pycampadb.msvc.api.request.discount.DiscountRequest;

public interface DiscountService {
    void createDiscount(DiscountRequest request);
}
