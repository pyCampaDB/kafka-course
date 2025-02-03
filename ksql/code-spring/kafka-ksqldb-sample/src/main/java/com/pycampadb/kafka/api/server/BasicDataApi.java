package com.pycampadb.kafka.api.server;

import com.pycampadb.kafka.api.request.*;
import com.pycampadb.kafka.command.service.BasicDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
@RequestMapping("api/basic-data")
public class BasicDataApi {
    private final BasicDataService service;

    public BasicDataApi(BasicDataService service) {
        this.service = service;
    }

    @PostMapping(value = "country", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BasicDataCountryRequest> createBasicDataCountry (
            @RequestBody BasicDataCountryRequest request
    ) {
        service.createBasicDataCountry(request);
        return ResponseEntity.status(CREATED).body(request);
    }

    @PostMapping(value = "five", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BasicDataFiveRequest> createBasicDataFive (
            @RequestBody BasicDataFiveRequest request
    ) {
        service.createBasicDataFive(request);
        return ResponseEntity.status(CREATED).body(request);
    }

    @PostMapping(value = "four", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BasicDataFourRequest> createBasicDataFour (
            @RequestBody BasicDataFourRequest request
    ) {
        service.createBasicDataFour(request);
        return ResponseEntity.status(CREATED).body(request);
    }

    @PostMapping (value = "one", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BasicDataOneRequest> createBasicDataOne (
            @RequestBody BasicDataOneRequest request
    ) {
        service.createBasicDataOne(request);
        return ResponseEntity.status(CREATED).body(request);
    }

    @PostMapping (value = "person", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BasicDataPersonRequest> createBasicDataPerson (
            @RequestBody BasicDataPersonRequest request
    ) {
        service.createBasicDataPerson(request);
        return ResponseEntity.status(CREATED).body(request);
    }

    @PostMapping (value = "three", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BasicDataThreeRequest> createBasicDataThree (
            @RequestBody BasicDataThreeRequest request
    ) {
        service.createBasicDataThree(request);
        return ResponseEntity.status(CREATED).body(request);
    }

    @PostMapping (value = "two", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BasicDataTwoRequest> createBasicDataTwo (
            @RequestBody BasicDataTwoRequest request
    ) {
        service.createBasicDataTwo(request);
        return ResponseEntity.status(CREATED).body(request);
    }

    @DeleteMapping (value = "country/{countryName}", produces = TEXT_PLAIN_VALUE)
    public ResponseEntity<String> deleteBasicCountry (
            @PathVariable (name = "countryName") String countryName
    ) {
        service.deleteBasicDataCountry(countryName);
        return ResponseEntity.status(NO_CONTENT).body("Deleted " + countryName);
    }
}
