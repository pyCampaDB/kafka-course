package com.pycampadb;

import com.pycampadb.entity.FoodOrder;
import com.pycampadb.producer.FoodOrderProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
//@EnableScheduling
public class KafkaCommodityProducerApplication implements CommandLineRunner {
	//private final CounterProducer counterProducer
	//private final PurchaseRequestProducer purchaseRequestProducer
	//private final PaymentRequestProducer paymentRequestProducer
	



    public static void main(String[] args) {
		SpringApplication.run(KafkaCommodityProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//counterProducer.sendMessages(100)
		/*var request1 = new PurchaseRequest(UUID.randomUUID(), "REQ-001", 100, "USD")
		var request2 = new PurchaseRequest(UUID.randomUUID(), "REQ-002", 200, "EUR")
		var request3 = new PurchaseRequest(UUID.randomUUID(), "REQ-003", 300, "GBP")

		purchaseRequestProducer.sendPurchaseRequest(request1)
		purchaseRequestProducer.sendPurchaseRequest(request2)
		purchaseRequestProducer.sendPurchaseRequest(request3)

		purchaseRequestProducer.sendPurchaseRequest(request1)*/
		/*PaymentRequest payment1 = new PaymentRequest(100, "USD", "1234567890", "Payment 1", LocalDate.now())
		PaymentRequest payment2 = new PaymentRequest(200, "USD", "1234567890", "Payment 2", LocalDate.now())
		PaymentRequest payment3 = new PaymentRequest(300, "USD", "0987654321", "Payment 3", LocalDate.now())
		PaymentRequest payment4 = new PaymentRequest(400, "USD", "0987654321", "Payment 4", LocalDate.now())
		PaymentRequest payment5 = new PaymentRequest(500, "USD", "1122334455", "Payment 5", LocalDate.now())
		PaymentRequest payment6 = new PaymentRequest(600, "USD", "1122334455", "Payment 6", LocalDate.now())

		paymentRequestProducer.sendPaymentRequest(payment1)
		paymentRequestProducer.sendPaymentRequest(payment2)
		paymentRequestProducer.sendPaymentRequest(payment3)
		paymentRequestProducer.sendPaymentRequest(payment4)
		paymentRequestProducer.sendPaymentRequest(payment5)
		paymentRequestProducer.sendPaymentRequest(payment6)

		paymentRequestProducer.sendPaymentRequest(payment1)
		paymentRequestProducer.sendPaymentRequest(payment2)*/

		
	}
}
