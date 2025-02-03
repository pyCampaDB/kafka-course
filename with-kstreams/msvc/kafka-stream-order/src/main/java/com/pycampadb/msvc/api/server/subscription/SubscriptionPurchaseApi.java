package com.pycampadb.msvc.api.server.subscription;

import com.pycampadb.msvc.api.request.subscription.SubscriptionPurchaseRequest;
import com.pycampadb.msvc.command.service.subscription.SubscriptionPurchaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
@RequestMapping("api/subscription/purchase")
public class SubscriptionPurchaseApi {
    private final SubscriptionPurchaseService service;

    public SubscriptionPurchaseApi(SubscriptionPurchaseService service) {
        this.service = service;
    }

    @PostMapping(value = "", consumes = APPLICATION_JSON_VALUE, produces = TEXT_PLAIN_VALUE)
    public ResponseEntity<String> postSubscriptionPurchase (@RequestBody SubscriptionPurchaseRequest request){
        service.createSubscriptionPurchase(request);
        return ResponseEntity.status(CREATED).body(
                "Subscription purchase created, username: " + request.getUsername() +
                        ", number: " + request.getSubscriptionNumber()
        );
    }
}
