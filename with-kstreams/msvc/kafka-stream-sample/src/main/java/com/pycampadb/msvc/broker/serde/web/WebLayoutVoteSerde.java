package com.pycampadb.msvc.broker.serde.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pycampadb.msvc.broker.message.WebLayoutVoteMessage;
import com.pycampadb.msvc.broker.serde.CustomJsonDeserializer;
import com.pycampadb.msvc.broker.serde.CustomJsonSerde;
import com.pycampadb.msvc.broker.serde.CustomJsonSerializer;
import org.springframework.beans.factory.annotation.Autowired;

public class WebLayoutVoteSerde extends CustomJsonSerde<WebLayoutVoteMessage> {
    @Autowired
    public WebLayoutVoteSerde(ObjectMapper mapper){
        super(new CustomJsonSerializer<>(mapper), new CustomJsonDeserializer<>(mapper, WebLayoutVoteMessage.class));
    }
}
