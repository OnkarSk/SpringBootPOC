package com.example.dealer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class DealerInformationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DealerInformationApplication.class, args);
		System.out.println("hello spring boot");
	}

}
