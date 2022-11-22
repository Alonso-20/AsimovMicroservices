package com.asimov.directorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class DirectorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DirectorServiceApplication.class, args);
	}

}
