package com.ashok.in;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpmsGreetApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpmsGreetApiApplication.class, args);
	}

}
