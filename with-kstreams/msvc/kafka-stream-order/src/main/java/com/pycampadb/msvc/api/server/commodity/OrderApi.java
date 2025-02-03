package com.pycampadb.msvc.api.server.commodity;

import com.pycampadb.msvc.api.request.commodity.OrderRequest;
import com.pycampadb.msvc.api.response.commodity.OrderResponse;
import com.pycampadb.msvc.command.service.commodity.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/order")
public class OrderApi {
    private final OrderService service;

    public OrderApi(OrderService service) {
        this.service = service;
    }

    @PostMapping(value = "", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderResponse> createOrder (@RequestBody OrderRequest orderRequest){
        // 1. SAVE ORDER USING THE SERVICE
        var orderNumber = service.saveOrder(orderRequest);

        //2. construct OrderResponse
        var response = new OrderResponse(orderNumber);

        //3. return the response
        return ResponseEntity.ok(response);
    }
}
