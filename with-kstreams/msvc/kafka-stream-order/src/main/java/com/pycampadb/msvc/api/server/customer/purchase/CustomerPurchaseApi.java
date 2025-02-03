package com.pycampadb.msvc.api.server.customer.purchase;

import com.pycampadb.msvc.api.request.customer.purchase.CustomerPurchaseMobileRequest;
import com.pycampadb.msvc.api.request.customer.purchase.CustomerPurchaseWebRequest;
import com.pycampadb.msvc.api.response.customer.purchase.PurchaseResponse;
import com.pycampadb.msvc.command.service.customer.purchase.CustomerPurchaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/customer/purchase")
public class CustomerPurchaseApi {
    private final CustomerPurchaseService service;

    public CustomerPurchaseApi(CustomerPurchaseService service) {
        this.service = service;
    }

    @PostMapping(value = "mobile", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PurchaseResponse> createPurchaseMobile(@RequestBody CustomerPurchaseMobileRequest request){
        var purchaseNumber = service.createPurchaseMobile(request);
        return ResponseEntity.status(CREATED).body(new PurchaseResponse(purchaseNumber));
    }

    @PostMapping(value = "web", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PurchaseResponse> createPurchaseWeb(@RequestBody CustomerPurchaseWebRequest request){
        var purchaseNumber = service.createPurchaseWeb(request);
        return ResponseEntity.status(CREATED).body(new PurchaseResponse(purchaseNumber));
    }
}
