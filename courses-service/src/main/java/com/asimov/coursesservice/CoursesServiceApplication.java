package com.asimov.coursesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CoursesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursesServiceApplication.class, args);
	}

}
