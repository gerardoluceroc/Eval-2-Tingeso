package com.service.inasistenciaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class InasistenciaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InasistenciaServiceApplication.class, args);
	}

}
