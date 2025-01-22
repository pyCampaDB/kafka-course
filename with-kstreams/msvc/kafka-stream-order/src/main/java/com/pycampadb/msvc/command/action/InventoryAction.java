package com.pycampadb.msvc.command.action;

import com.pycampadb.msvc.api.request.InventoryRequest;

public interface InventoryAction {
    void sendInventoryMessageToKafka(InventoryRequest request, String type);
}
