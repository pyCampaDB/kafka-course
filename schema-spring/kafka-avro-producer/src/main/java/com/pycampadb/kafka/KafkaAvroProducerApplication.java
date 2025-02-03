package com.pycampadb.kafka;


import com.pycampadb.avro.data.Avro01;
import com.pycampadb.kafka.broker.producer.Avro01Producer;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;


@SpringBootApplication
//@EnableScheduling
public class KafkaAvroProducerApplication implements CommandLineRunner {
	private final Avro01Producer producer;

    public KafkaAvroProducerApplication(Avro01Producer producer) {
        this.producer = producer;
    }


    public static void main(String[] args) {
		SpringApplication.run(KafkaAvroProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 300; i++){
			var faker = new Faker();
			var data = Avro01.newBuilder()
					.setFullName(faker.naruto().character())
					.setActive(true)
					.setMaritalStatus("SINGLE")
					.build();
			producer.send(data);

			TimeUnit.SECONDS.sleep(1);
		}


		/*var data = Avro02.newBuilder()
				.setMyDate(LocalDate.now())
				.setMyDecimal(new BigDecimal("10472.281474693").setScale(5, RoundingMode.HALF_UP))
				.setMyTimeMillis(LocalTime.now())
				.setMyTimestampMillis(Instant.now())
				.setMyUUID(UUID.randomUUID())
				.build()
		producer.send(data)*/
	}
}
