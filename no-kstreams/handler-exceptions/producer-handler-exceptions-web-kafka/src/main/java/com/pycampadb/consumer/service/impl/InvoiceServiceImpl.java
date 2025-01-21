package com.pycampadb.consumer.service.impl;

import com.pycampadb.consumer.entity.Invoice;
import com.pycampadb.consumer.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    private static final AtomicInteger COUNTER = new AtomicInteger();

    @Override
    public Invoice generateInvoice() {
        var invoiceNumber = "INV" + COUNTER.incrementAndGet();
        var amount = Math.round(ThreadLocalRandom.current().nextDouble(100, 1000)*100.0)/100.0;

        return new Invoice(invoiceNumber, amount, "EUR");
    }
}
