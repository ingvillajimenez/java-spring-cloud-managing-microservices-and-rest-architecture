package com.examplerest.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.examplerest"})
public class RestServiceSample2Application {

	public static void main(String[] args) {
		SpringApplication.run(RestServiceSample2Application.class, args);
	}

}
