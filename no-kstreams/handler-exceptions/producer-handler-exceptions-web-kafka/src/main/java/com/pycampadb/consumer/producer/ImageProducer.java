package com.pycampadb.consumer.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pycampadb.consumer.entity.Image;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ImageProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;


    public ImageProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendImageToPartition(Image image, int partition){
        try{
            var imageJson = objectMapper.writeValueAsString(image);
            kafkaTemplate.send("t-image", partition, image.getType(), imageJson);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
