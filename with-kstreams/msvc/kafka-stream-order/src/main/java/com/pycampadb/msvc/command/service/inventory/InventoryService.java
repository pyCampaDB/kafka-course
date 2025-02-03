package com.pycampadb.msvc.command.service.inventory;

import com.pycampadb.msvc.api.request.inventory.InventoryRequest;

public interface InventoryService {
    void addInventory(InventoryRequest request);
    void subtractInventory(InventoryRequest request);
}
