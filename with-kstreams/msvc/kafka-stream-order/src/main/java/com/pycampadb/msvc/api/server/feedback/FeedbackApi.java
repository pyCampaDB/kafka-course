package com.pycampadb.msvc.api.server.feedback;

import com.pycampadb.msvc.api.request.feedback.FeedbackRequest;
import com.pycampadb.msvc.command.service.feedback.FeedbackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
@RequestMapping("api/feedback")
public class FeedbackApi {
    private final FeedbackService service;

    public FeedbackApi(FeedbackService service) {
        this.service = service;
    }

    @PostMapping(value = "", consumes = APPLICATION_JSON_VALUE, produces = TEXT_PLAIN_VALUE)
    public ResponseEntity<String> createFeedback(@RequestBody FeedbackRequest request){
        service.createFeedback(request);
        return ResponseEntity.status(CREATED).body("Thanks for your feedback");
    }
}
