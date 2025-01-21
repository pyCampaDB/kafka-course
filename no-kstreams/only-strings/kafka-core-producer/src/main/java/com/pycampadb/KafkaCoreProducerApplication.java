package com.pycampadb;

//import com.pycampadb.producer.HelloKafkaProducer
import com.pycampadb.producer.KafkaKeyProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.scheduling.annotation.EnableScheduling

//import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.TimeUnit;

@SpringBootApplication
//@EnableScheduling
public class KafkaCoreProducerApplication implements CommandLineRunner {
	//private final HelloKafkaProducer helloKafkaProducer
	private final KafkaKeyProducer kafkaKeyProducer;

	public KafkaCoreProducerApplication(/*HelloKafkaProducer helloKafkaProducer, */KafkaKeyProducer kafkaKeyProducer) {
        this.kafkaKeyProducer = kafkaKeyProducer;
        //this.helloKafkaProducer = helloKafkaProducer
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaCoreProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//helloKafkaProducer.sendHello("Kenpachi " + ThreadLocalRandom.current().nextInt(1000))
		for (int i = 1; i <= 10_000; i++){
			String key = "key-" + i;
			String message = "Message " + i;
			kafkaKeyProducer.sendMessage(key, message);
			TimeUnit.SECONDS.sleep(1);
		}
	}
}
