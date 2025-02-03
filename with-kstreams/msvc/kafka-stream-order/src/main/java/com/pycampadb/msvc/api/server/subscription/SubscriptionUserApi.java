package com.pycampadb.msvc.api.server.subscription;

import com.pycampadb.msvc.api.request.subscription.SubscriptionUserRequest;
import com.pycampadb.msvc.command.service.subscription.SubscriptionUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
@RequestMapping("api/subscription/user")
public class SubscriptionUserApi {
    private final SubscriptionUserService service;

    public SubscriptionUserApi(SubscriptionUserService service) {
        this.service = service;
    }

    @PostMapping(value = "", consumes = APPLICATION_JSON_VALUE, produces = TEXT_PLAIN_VALUE)
    public ResponseEntity<String> postSubscriptionUser (@RequestBody SubscriptionUserRequest request){
        service.createSubscriptionUser(request);
        return ResponseEntity.status(CREATED).body(
                "Subscription user created, username: " + request.getUsername() +
                        ", duration: " + request.getDuration()
        );
    }
}
