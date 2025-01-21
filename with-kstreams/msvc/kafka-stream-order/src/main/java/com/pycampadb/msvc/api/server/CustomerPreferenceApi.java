package com.pycampadb.msvc.api.server;

import com.pycampadb.msvc.api.request.CustomerPreferenceShoppingCartRequest;
import com.pycampadb.msvc.api.request.CustomerPreferenceWishlistRequest;
import com.pycampadb.msvc.command.service.CustomerPreferenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/customer/preference")
public class CustomerPreferenceApi {
    private final CustomerPreferenceService service;

    public CustomerPreferenceApi(CustomerPreferenceService service) {
        super();
        this.service = service;
    }

    @PostMapping(value = "shopping-cart", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createShoppingCart(@RequestBody CustomerPreferenceShoppingCartRequest request){
        var response = service.publishShoppingCartToKafka(request);
        return ResponseEntity.status(CREATED).body(response);
    }

    @PostMapping(value = "wishlist", consumes = APPLICATION_JSON_VALUE, produces=APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createWishlist(@RequestBody CustomerPreferenceWishlistRequest request){
        var response = service.publishWishlistToKafka(request);
        return ResponseEntity.status(CREATED).body(response);
    }
}
