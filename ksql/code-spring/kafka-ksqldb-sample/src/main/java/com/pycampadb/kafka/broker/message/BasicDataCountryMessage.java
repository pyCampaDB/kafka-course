package com.pycampadb.kafka.broker.message;

public class BasicDataCountryMessage {
    private String countryName;
    private String currencyCode;
    private Integer population;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "BasicDataCountryMessage{" +
                "countryName='" + countryName + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", population=" + population +
                '}';
    }
}
