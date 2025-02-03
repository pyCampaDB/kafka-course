package com.pycampadb.kafka.command.service.impl;

import com.pycampadb.kafka.api.request.*;
import com.pycampadb.kafka.command.action.BasicDataAction;
import com.pycampadb.kafka.command.service.BasicDataService;
import org.springframework.stereotype.Service;

@Service
public class BasicDataServiceImpl implements BasicDataService {

    private final BasicDataAction action;

    public BasicDataServiceImpl(BasicDataAction action) {
        this.action = action;
    }

    @Override
    public void createBasicDataCountry(BasicDataCountryRequest request) {
        action.publishBasicDataCountry(request);
    }

    @Override
    public void createBasicDataFive(BasicDataFiveRequest request) {
        action.publishBasicDataFive(request);
    }

    @Override
    public void createBasicDataFour(BasicDataFourRequest request) {
        action.publishBasicDataFour(request);
    }

    @Override
    public void createBasicDataOne(BasicDataOneRequest request) {
        action.publishBasicDataOne(request);
    }

    @Override
    public void createBasicDataPerson(BasicDataPersonRequest request) {
        action.publishBasicDataPerson(request);
    }

    @Override
    public void createBasicDataThree(BasicDataThreeRequest request) {
        action.publishBasicDataThree(request);
    }

    @Override
    public void createBasicDataTwo(BasicDataTwoRequest request) {
        action.publishBasicDataTwo(request);
    }

    @Override
    public void deleteBasicDataCountry(String countryName) {
        action.deleteBasicDataCountry(countryName);
    }
}
