package com.pycampadb.msvc.api.server;

import com.pycampadb.msvc.api.request.DiscountRequest;
import com.pycampadb.msvc.command.service.DiscountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/discount")
public class DiscountApi {
    private final DiscountService service;

    public DiscountApi(DiscountService service) {
        this.service = service;
    }

    @PostMapping(value = "", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createDiscount(@RequestBody DiscountRequest request){
        service.createDiscount(request);
        return ResponseEntity.status(CREATED).body(
                request.getDiscountCode() + " with " + request.getDiscountPercentage() + "% discount"
        );
    }
}
