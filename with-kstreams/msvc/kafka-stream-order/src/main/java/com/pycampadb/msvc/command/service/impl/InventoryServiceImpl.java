package com.pycampadb.msvc.command.service.impl;

import com.pycampadb.msvc.api.request.InventoryRequest;
import com.pycampadb.msvc.command.action.InventoryAction;
import com.pycampadb.msvc.command.service.InventoryService;
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
