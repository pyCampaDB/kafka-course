package com.pycampadb.consumer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ProducerHandlerExceptionsWebKafkaApplication implements CommandLineRunner {

	/*
	private final Image2Producer image2Producer
	private final ImageService imageService
	 */
	/*
	private final InvoiceService invoiceService
	private final InvoiceProducer invoiceProducer
	*/

    public static void main(String[] args) {
		SpringApplication.run(ProducerHandlerExceptionsWebKafkaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		var image1 = imageService.generateImage("JPG")
		var image2 = imageService.generateImage("SVG")
		var image3 = imageService.generateImage("PNG")
		var image4 = imageService.generateImage("GIF")
		var image5 = imageService.generateImage("BMP")
		var image6 = imageService.generateImage("TIFF")

		image2Producer.sendImageToPartition(image1, 0)
		image2Producer.sendImageToPartition(image2, 0)
		image2Producer.sendImageToPartition(image3, 0)

		image2Producer.sendImageToPartition(image4, 1)
		image2Producer.sendImageToPartition(image5, 1)
		image2Producer.sendImageToPartition(image6, 1)
		*/
	/*
	for i 0 -> 10
			var invoice = invoiceService.generateInvoice()
			si i > 5
				invoice.setAmount(0d)
			invoiceProducer.sendInvoice(invoice)
		 */
	}

}
