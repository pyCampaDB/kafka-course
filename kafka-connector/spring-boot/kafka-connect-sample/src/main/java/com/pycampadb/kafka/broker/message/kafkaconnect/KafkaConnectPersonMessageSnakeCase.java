package com.pycampadb.kafka.broker.message.kafkaconnect;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class KafkaConnectPersonMessageSnakeCase {
    private int personId;
    private String fullName;
    private String email;
    private List<KafkaConnectAddressMessageSnakeCase> addresses;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<KafkaConnectAddressMessageSnakeCase> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<KafkaConnectAddressMessageSnakeCase> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "KafkaConnectPersonMessageSnakeCase{" +
                "personId=" + personId +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}
