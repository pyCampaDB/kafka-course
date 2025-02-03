package com.pycampadb.kafka.command.service;

import com.pycampadb.kafka.api.request.*;

public interface BasicDataService {
    void createBasicDataCountry(BasicDataCountryRequest request);
    void createBasicDataFive (BasicDataFiveRequest request);
    void createBasicDataFour (BasicDataFourRequest request);
    void createBasicDataOne (BasicDataOneRequest request);
    void createBasicDataPerson (BasicDataPersonRequest request);
    void createBasicDataThree (BasicDataThreeRequest request);
    void createBasicDataTwo (BasicDataTwoRequest request);
    void deleteBasicDataCountry (String countryName);
}