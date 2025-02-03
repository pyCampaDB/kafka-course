package com.pycampadb.msvc.api.server.web;

import com.pycampadb.msvc.api.request.web.WebLayoutVoteRequest;
import com.pycampadb.msvc.command.service.web.WebLayoutVoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
@RequestMapping("api/web/layout/vote")
public class WebLayoutVoteApi {
    private final WebLayoutVoteService service;

    public WebLayoutVoteApi(WebLayoutVoteService service) {
        this.service = service;
    }

    @PostMapping(value = "", consumes = APPLICATION_JSON_VALUE, produces = TEXT_PLAIN_VALUE)
    public ResponseEntity<String> postWebLayoutVote (@RequestBody WebLayoutVoteRequest request){
        service.createWebLayoutVote(request);
        return ResponseEntity.status(CREATED).body(
            "Saved Web Layout Vote by " + request.getUsername()
        );
    }
}
