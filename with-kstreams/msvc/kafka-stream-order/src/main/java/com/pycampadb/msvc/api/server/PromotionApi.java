package com.pycampadb.msvc.api.server;

import com.pycampadb.msvc.api.request.PromotionRequest;
import com.pycampadb.msvc.command.service.PromotionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/promotion")
public class PromotionApi {
    private final PromotionService service;

    public PromotionApi(PromotionService service) {
        this.service = service;
    }

    @PostMapping(value = "", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createPromotion(@RequestBody PromotionRequest request){
        service.createPromotion(request);
        return new ResponseEntity<>(request.getPromotionCode(), CREATED);
    }
}
