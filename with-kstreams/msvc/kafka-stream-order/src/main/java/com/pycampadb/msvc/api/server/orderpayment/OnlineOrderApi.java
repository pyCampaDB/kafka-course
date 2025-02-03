package com.pycampadb.msvc.api.server.orderpayment;

import com.pycampadb.msvc.api.request.orderpayment.OnlineOrderRequest;
import com.pycampadb.msvc.command.service.orderpayment.OnlineOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/order/online")
public class OnlineOrderApi {
    private final OnlineOrderService service;

    public OnlineOrderApi(OnlineOrderService service) {
        this.service = service;
    }

    @PostMapping(value = "", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createOnlineOrder(@RequestBody OnlineOrderRequest request){
        service.createOnlineOrder(request);
        return ResponseEntity.status(CREATED).body("Saved online order: " + request.getOnlineOrderNumber());
    }
}
