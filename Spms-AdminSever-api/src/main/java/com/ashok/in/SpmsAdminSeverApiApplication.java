package com.ashok.in;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@EnableAdminServer
@SpringBootApplication
public class SpmsAdminSeverApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpmsAdminSeverApiApplication.class, args);
	}

}
