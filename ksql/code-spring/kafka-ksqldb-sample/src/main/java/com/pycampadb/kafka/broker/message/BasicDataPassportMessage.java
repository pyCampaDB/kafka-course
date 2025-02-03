package com.pycampadb.kafka.broker.message;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class BasicDataPassportMessage {
    private String number;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expirationDate;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "BasicDataPassportMessage{" +
                "number='" + number + '\'' +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
