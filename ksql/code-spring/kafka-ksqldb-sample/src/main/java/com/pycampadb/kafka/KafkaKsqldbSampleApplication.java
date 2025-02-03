package com.pycampadb.kafka;

import com.pycampadb.kafka.ksqldb.client.BasicJavaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaKsqldbSampleApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(KafkaKsqldbSampleApplication.class);

	public KafkaKsqldbSampleApplication(BasicJavaClient client) {
        this.client = client;
    }

    public static void main(String[] args) {
		SpringApplication.run(KafkaKsqldbSampleApplication.class, args);
	}
	private final BasicJavaClient client;
	@Override
	public void run(String... args) throws Exception {
		//client.createStream()
		//client.describeStream()
		//client.listObjects()

		/*fo (int i = 0; i < 5; i++)
			client.insertSingle()
		*/
		//client.insertStream(20)
		//client.pullQuery()

		//log.info("Starting pushQuerySync()")
		//client.pushQuerySync()
		client.pushQueryAsync();
		log.info("Este método no es bloqueante, aunque falla porque con Java 17 no furula");
	}
}
