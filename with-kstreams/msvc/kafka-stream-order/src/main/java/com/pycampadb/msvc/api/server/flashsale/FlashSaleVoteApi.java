package com.pycampadb.msvc.api.server.flashsale;

import com.pycampadb.msvc.api.request.flashsale.FlashSaleVoteRequest;
import com.pycampadb.msvc.command.service.flashsale.FlashSaleVoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/flash-sale/vote")
public class FlashSaleVoteApi {
    private final FlashSaleVoteService service;

    public FlashSaleVoteApi(FlashSaleVoteService service) {
        this.service = service;
    }

    @PostMapping(value = "", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createFlashSaleVote(@RequestBody FlashSaleVoteRequest request){
        var customerId = service.createFlashSaleVote(request);
        return ResponseEntity.status(CREATED).body(
                "Flash sale vote created for customer : "
                + customerId + ", item : " + request.getItemName()
        );
    }
}
