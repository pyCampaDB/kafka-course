package com.pycampadb.msvc.command.service.inventory.impl;

import com.pycampadb.msvc.api.request.inventory.InventoryRequest;
import com.pycampadb.msvc.command.action.inventory.InventoryAction;
import com.pycampadb.msvc.command.service.inventory.InventoryService;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {
    private final InventoryAction action;

    public InventoryServiceImpl(InventoryAction action) {
        this.action = action;
    }

    @Override
    public void addInventory(InventoryRequest request) {
        action.sendInventoryMessageToKafka(request, "ADD");
    }

    @Override
    public void subtractInventory(InventoryRequest request) {
        action.sendInventoryMessageToKafka(request, "REMOVE");
    }
}
