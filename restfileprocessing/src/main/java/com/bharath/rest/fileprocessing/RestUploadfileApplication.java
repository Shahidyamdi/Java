package com.bharath.rest.fileprocessing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestUploadfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestUploadfileApplication.class, args);

	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();

	}

}
