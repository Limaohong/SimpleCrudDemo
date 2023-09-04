package com.example.customerSimpleCrudDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAwareByCustomer")
public class CustomerCurDdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerCurDdemoApplication.class, args);
	}

}
