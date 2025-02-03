package com.pycampadb.msvc.api.server.premium;

import com.pycampadb.msvc.api.request.premium.PremiumUserRequest;
import com.pycampadb.msvc.command.service.premium.PremiumUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
@RequestMapping("api/premium/user")
public class PremiumUserApi {
    private final PremiumUserService service;

    public PremiumUserApi(PremiumUserService service) {
        this.service = service;
    }

    @PostMapping(value = "", consumes = APPLICATION_JSON_VALUE, produces = TEXT_PLAIN_VALUE)
    public ResponseEntity<String> postPremiumUser (@RequestBody PremiumUserRequest request){
        service.createPremiumUser(request);
        return ResponseEntity.status(CREATED).body(
                "Premium User created, username: " + request.getUsername() +
                        ", level: " + request.getLevel()
        );
    }
}
