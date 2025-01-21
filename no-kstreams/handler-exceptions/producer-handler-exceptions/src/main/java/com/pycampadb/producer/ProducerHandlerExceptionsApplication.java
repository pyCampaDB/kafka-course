package com.pycampadb.producer;

import com.pycampadb.producer.entity.FoodOrder;
import com.pycampadb.producer.entity.SimpleNumber;
import com.pycampadb.producer.producer.FoodOrderProducer;
import com.pycampadb.producer.producer.SimpleNumberProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProducerHandlerExceptionsApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(ProducerHandlerExceptionsApplication.class);
	private final FoodOrderProducer foodOrderProducer;
	private final SimpleNumberProducer simpleNumberProducer;

    public ProducerHandlerExceptionsApplication(FoodOrderProducer foodOrderProducer, SimpleNumberProducer simpleNumberProducer) {
        this.foodOrderProducer = foodOrderProducer;
        this.simpleNumberProducer = simpleNumberProducer;
    }


    public static void main(String[] args) {
		SpringApplication.run(ProducerHandlerExceptionsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		var chickenOrder = new FoodOrder(3, "chicken");
		var fishOrder = new FoodOrder(4, "fish");
		var pizzaOrder = new FoodOrder(10, "pizza");

		foodOrderProducer.sendFoodOrder(chickenOrder);
		foodOrderProducer.sendFoodOrder(pizzaOrder);
		foodOrderProducer.sendFoodOrder(fishOrder);

		for (int i=100; i< 103; i++){
			var simpleNumber = new SimpleNumber(i);
			simpleNumberProducer.sendSimpleNumber(simpleNumber);
			log.info("Sent simpleNumber {}", i);
		}
	}
}
