package com.pycampadb.msvc.api.server;

import com.pycampadb.msvc.api.request.InventoryRequest;
import com.pycampadb.msvc.command.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
@RequestMapping("api/inventory")
public class InventoryApi {
    private final InventoryService service;

    public InventoryApi(InventoryService service) {
        this.service = service;
    }

    @PostMapping(value = "add", consumes = APPLICATION_JSON_VALUE, produces = TEXT_PLAIN_VALUE)
    public ResponseEntity<String> addInventory(@RequestBody InventoryRequest request){
        service.addInventory(request);
        return ResponseEntity.status(CREATED).body("Added inventory: " + request.toString());
    }

    @PostMapping(value = "subtract", consumes = APPLICATION_JSON_VALUE, produces = TEXT_PLAIN_VALUE)
    public ResponseEntity<String> subtractInventory(@RequestBody InventoryRequest request){
        service.subtractInventory(request);
        return ResponseEntity.ok().body("Removed inventory: " + request.toString());
    }


}
