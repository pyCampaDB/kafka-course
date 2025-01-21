package com.pycampadb.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pycampadb.entity.Commodity;
import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service

//@Service
public class CommodityProducer {
    private final KafkaTemplate<String, String> template;
    private final ObjectMapper mapper;

    public CommodityProducer(KafkaTemplate<String, String> template, ObjectMapper mapper) {
        this.template = template;
        this.mapper = mapper;
    }

    public void sendMessage(Commodity commodity){
        try{
            var json = mapper.writeValueAsString(commodity);
            template.send("t-commodity",commodity.getName(), json);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
