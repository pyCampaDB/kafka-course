package com.pycampadb.msvc.api.server.premium;

import com.pycampadb.msvc.api.request.premium.PremiumPurchaseRequest;
import com.pycampadb.msvc.command.service.premium.PremiumPurchaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
@RequestMapping("api/premium/purchase")
public class PremiumPurchaseApi {
    private final PremiumPurchaseService service;

    public PremiumPurchaseApi(PremiumPurchaseService service) {
        this.service = service;
    }

    @PostMapping(value = "", consumes = APPLICATION_JSON_VALUE, produces = TEXT_PLAIN_VALUE)
    public ResponseEntity<String> postPremiumPurchase (@RequestBody PremiumPurchaseRequest request){
        if (request.getUsername().equalsIgnoreCase("babi"))
            throw new NullPointerException();
        service.createPremiumPurchase(request);
        return ResponseEntity.status(CREATED).body(
                "Premium purchase created, username : " + request.getUsername() +
                        ", item: " + request.getItem() + ", number: " + request.getPurchaseNumber()
        );
    }
}
