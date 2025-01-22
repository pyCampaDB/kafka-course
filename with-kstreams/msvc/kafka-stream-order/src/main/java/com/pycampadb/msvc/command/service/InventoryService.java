package com.pycampadb.msvc.command.service;

import com.pycampadb.msvc.api.request.InventoryRequest;

public interface InventoryService {
    void addInventory(InventoryRequest request);
    void subtractInventory(InventoryRequest request);
}
