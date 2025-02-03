package com.pycampadb.ui.api;

import org.apache.kafka.streams.StreamsBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/kafka/stream/topology")
public class KafkaUiApi {
    private final StreamsBuilder streamsBuilder;

    public KafkaUiApi(StreamsBuilder streamsBuilder) {
        this.streamsBuilder = streamsBuilder;
    }

    @GetMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public String topology (){
        return streamsBuilder.build().describe().toString();
    }
}
