package com.pycampadb.kafka.broker.message;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;

public class BasicDataThreeMessage {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate myLocalDate;
    @JsonFormat(pattern = "dd MMM yyyy")
    private LocalDate myLocalDateCustomFormat;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime myLocalTime;
    @JsonFormat(pattern = "hh:mm:ss a")
    private LocalTime myLocalTimeCustomFormat;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime myLocalDateTime;
    @JsonFormat(pattern = "dd-MMM-yyyy hh:mm:ss a")
    private LocalDateTime myLocalDateTimeCustomFormat;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private OffsetDateTime myOffsetDateTime;
    @JsonFormat(pattern = "dd-MMM-yyyy hh:mm:ss.SSS a Z")
    private OffsetDateTime myOffsetDateTimeCustomFormat;

    public LocalDate getMyLocalDate() {
        return myLocalDate;
    }

    public void setMyLocalDate(LocalDate myLocalDate) {
        this.myLocalDate = myLocalDate;
    }

    public LocalDate getMyLocalDateCustomFormat() {
        return myLocalDateCustomFormat;
    }

    public void setMyLocalDateCustomFormat(LocalDate myLocalDateCustomFormat) {
        this.myLocalDateCustomFormat = myLocalDateCustomFormat;
    }

    public LocalTime getMyLocalTime() {
        return myLocalTime;
    }

    public void setMyLocalTime(LocalTime myLocalTime) {
        this.myLocalTime = myLocalTime;
    }

    public LocalTime getMyLocalTimeCustomFormat() {
        return myLocalTimeCustomFormat;
    }

    public void setMyLocalTimeCustomFormat(LocalTime myLocalTimeCustomFormat) {
        this.myLocalTimeCustomFormat = myLocalTimeCustomFormat;
    }

    public LocalDateTime getMyLocalDateTime() {
        return myLocalDateTime;
    }

    public void setMyLocalDateTime(LocalDateTime myLocalDateTime) {
        this.myLocalDateTime = myLocalDateTime;
    }

    public LocalDateTime getMyLocalDateTimeCustomFormat() {
        return myLocalDateTimeCustomFormat;
    }

    public void setMyLocalDateTimeCustomFormat(LocalDateTime myLocalDateTimeCustomFormat) {
        this.myLocalDateTimeCustomFormat = myLocalDateTimeCustomFormat;
    }

    public OffsetDateTime getMyOffsetDateTime() {
        return myOffsetDateTime;
    }

    public void setMyOffsetDateTime(OffsetDateTime myOffsetDateTime) {
        this.myOffsetDateTime = myOffsetDateTime;
    }

    public OffsetDateTime getMyOffsetDateTimeCustomFormat() {
        return myOffsetDateTimeCustomFormat;
    }

    public void setMyOffsetDateTimeCustomFormat(OffsetDateTime myOffsetDateTimeCustomFormat) {
        this.myOffsetDateTimeCustomFormat = myOffsetDateTimeCustomFormat;
    }

    @Override
    public String toString() {
        return "BasicDataThreeMessage{" +
                "myLocalDate=" + myLocalDate +
                ", myLocalDateCustomFormat=" + myLocalDateCustomFormat +
                ", myLocalTime=" + myLocalTime +
                ", myLocalTimeCustomFormat=" + myLocalTimeCustomFormat +
                ", myLocalDateTime=" + myLocalDateTime +
                ", myLocalDateTimeCustomFormat=" + myLocalDateTimeCustomFormat +
                ", myOffsetDateTime=" + myOffsetDateTime +
                ", getMyOffsetDateTimeCustomFormat=" + myOffsetDateTimeCustomFormat +
                '}';
    }
}
