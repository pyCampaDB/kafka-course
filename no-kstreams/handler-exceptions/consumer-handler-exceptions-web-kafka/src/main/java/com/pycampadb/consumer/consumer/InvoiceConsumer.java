package com.pycampadb.consumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pycampadb.consumer.entity.Invoice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InvoiceConsumer {
    private static final Logger log = LoggerFactory.getLogger(InvoiceConsumer.class);
    private final ObjectMapper mapper;

    public InvoiceConsumer(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @KafkaListener(topics = "t-invoice", concurrency = "2", containerFactory = "invoiceDltContainerFactory")
    public void consume(String message){
        try {
            var invoice = mapper.readValue(message, Invoice.class);

            if (invoice.getAmount() < 1)
                throw new IllegalArgumentException("Invalid amount: " + invoice.getAmount());
            log.info("Consumed invoice: {}", invoice);
        } catch (JsonProcessingException e){
            log.error("JsonProcessingException in InvoiceConsumer: {}", e.getMessage(), e);
        }
    }
}
