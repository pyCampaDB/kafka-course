package com.pycampadb.kafka.api.request;

public class BasicDataCountryRequest {
    private String countryName;
    private String currencyCode;
    private int population;

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

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "BasicDataCountryRequest{" +
                "countryName='" + countryName + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", population=" + population +
                '}';
    }
}
