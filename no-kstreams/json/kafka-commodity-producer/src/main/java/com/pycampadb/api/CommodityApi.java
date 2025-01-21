package com.pycampadb.api;

import com.pycampadb.entity.Commodity;
import com.pycampadb.service.CommodityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/commodity/v1")
public class CommodityApi {
    private final CommodityService service;

    public CommodityApi(CommodityService service) {
        this.service = service;
    }

    @GetMapping(value = "all", produces = APPLICATION_JSON_VALUE)
    public List<Commodity> generateAllCommodities(){
        return service.generateDummyCommodities();
    }
}
