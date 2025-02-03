package com.pycampadb.kafka.broker.message;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class BasicDataPersonMessage {
    private String firstName;
    private String lastName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private Map<String, String> contacts;
    private BasicDataPassportMessage passport;
    private List<BasicDataAddressMessage> addresses;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Map<String, String> getContacts() {
        return contacts;
    }

    public void setContacts(Map<String, String> contacts) {
        this.contacts = contacts;
    }

    public BasicDataPassportMessage getPassport() {
        return passport;
    }

    public void setPassport(BasicDataPassportMessage passport) {
        this.passport = passport;
    }

    public List<BasicDataAddressMessage> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<BasicDataAddressMessage> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "BasicDataPersonMessage{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", contacts=" + contacts +
                ", passport=" + passport +
                ", addresses=" + addresses +
                '}';
    }
}
