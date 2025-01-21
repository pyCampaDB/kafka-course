package com.pycampadb;

import com.pycampadb.entity.Employee;
import com.pycampadb.producer.Employee2JsonProducer;
//import com.pycampadb.producer.EmployeeJsonProducer
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
public class KafkaCoreProducerJsonApplication implements CommandLineRunner {
	private final Employee2JsonProducer employeeJsonProducer;

    public KafkaCoreProducerJsonApplication(Employee2JsonProducer employeeJsonProducer) {
        this.employeeJsonProducer = employeeJsonProducer;
    }

    public static void main(String[] args) {
		SpringApplication.run(KafkaCoreProducerJsonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i=0; i< 5; i++){
			Employee employee = new Employee(
					UUID.randomUUID().toString(),
					"Employee" + i,
					LocalDate.now().minusYears(20L+i)
			);
			employeeJsonProducer.sendMessage(employee);
		}
	}
}
