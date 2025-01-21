package com.pycampadb.consumer.service.impl;

import com.pycampadb.consumer.entity.Image;
import com.pycampadb.consumer.service.ImageService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ImageServiceImpl implements ImageService {
    private static final AtomicInteger COUNTER = new AtomicInteger();

    @Override
    public Image generateImage(String type){
        var name = "image-"+COUNTER.incrementAndGet();
        var size = ThreadLocalRandom.current().nextLong(100, 10_001);
        return new Image(name, size, type);
    }
}
