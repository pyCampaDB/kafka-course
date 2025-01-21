package com.pycampadb.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pycampadb.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmployeeJsonConsumer {
    private static final Logger log = LoggerFactory.getLogger(EmployeeJsonConsumer.class);
    private final ObjectMapper mapper;

    public EmployeeJsonConsumer(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @KafkaListener(topics = "t-employee-2")
    public void consume(String message){
        try{
            var employee = mapper.readValue(message, Employee.class);
            log.info("Employee is {}", employee);
        } catch (JsonProcessingException e) {
            log.error("Error parsing employee", e);
        }

    }
}
