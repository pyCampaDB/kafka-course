package com.pycampadb.kafka.broker.producer;

import com.pycampadb.kafka.broker.message.*;

public interface BasicDataProducer {
    void sendBasicDataCountry (BasicDataCountryMessage message);
    void sendBasicDataCountryWithNullValue (String countryName);
    void sendBasicDataFive (BasicDataFiveMessage message);
    void sendBasicDataFour (BasicDataFourMessage message);
    void sendBasicDataOne (BasicDataOneMessage message);
    void sendBasicDataPerson (BasicDataPersonMessage message);
    void sendBasicDataThree (BasicDataThreeMessage message);
    void sendBasicDataTwo (BasicDataTwoMessage message);
}
