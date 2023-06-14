package com.example.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class RestServiceSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestServiceSampleApplication.class, args);
	}

}
