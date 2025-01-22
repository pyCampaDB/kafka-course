package com.pycampadb.msvc.api.server;

import com.pycampadb.msvc.api.request.OnlinePaymentRequest;
import com.pycampadb.msvc.command.service.OnlinePaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
@RequestMapping("api/payment/online")
public class OnlinePaymentApi {
    private final OnlinePaymentService service;

    public OnlinePaymentApi(OnlinePaymentService service) {
        this.service = service;
    }

    @PostMapping(value = "", consumes = APPLICATION_JSON_VALUE, produces = TEXT_PLAIN_VALUE)
    public ResponseEntity<String> createOnlinePayment(@RequestBody OnlinePaymentRequest request){
        service.createOnlinePayment(request);
        return ResponseEntity.status(CREATED).body("Valid payment: " + request.getOnlineOrderNumber());
    }
}
