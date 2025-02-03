package com.pycampadb.kafka.command.action;

import com.pycampadb.kafka.api.request.*;

public interface BasicDataAction {
    void deleteBasicDataCountry (String countryName);
    void publishBasicDataCountry (BasicDataCountryRequest request);
    void publishBasicDataFive (BasicDataFiveRequest request);
    void publishBasicDataFour (BasicDataFourRequest request);
    void publishBasicDataOne (BasicDataOneRequest request);
    void publishBasicDataPerson (BasicDataPersonRequest request);
    void publishBasicDataThree (BasicDataThreeRequest request);
    void publishBasicDataTwo (BasicDataTwoRequest request);
}
