package com.hashkart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class HashkartApplication {

	public static void main(String[] args) {
		SpringApplication.run(HashkartApplication.class, args);
	}

}
