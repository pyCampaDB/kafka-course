package com.pycampadb.msvc.command.action.inventory;

import com.pycampadb.msvc.api.request.inventory.InventoryRequest;

public interface InventoryAction {
    void sendInventoryMessageToKafka(InventoryRequest request, String type);
}
