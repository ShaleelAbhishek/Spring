package com.abhi.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EmployeeServiceDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceDbApplication.class, args);

	}


}
