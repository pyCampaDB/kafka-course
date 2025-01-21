package com.pycampadb.scheduler;

import com.pycampadb.entity.Commodity;
import com.pycampadb.producer.CommodityProducer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

//@Component
public class CommodityScheduler {
    private RestTemplate restTemplate = new RestTemplate();
    private static final String COMMODITY_API_URL = "http://localhost:8080/api/commodity/v1/all";

    private final CommodityProducer producer;

    public CommodityScheduler(CommodityProducer producer) {
        this.producer = producer;
    }

    @Scheduled(fixedRate = 5000)
    public void fetchAndSendCommodities(){
        Commodity[] commodities = restTemplate.getForObject(COMMODITY_API_URL, Commodity[].class);
        if (commodities!=null)
            Arrays.stream(commodities).forEach(producer::sendMessage);
    }
}
