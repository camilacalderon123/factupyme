package com.soltec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class MicroservicioClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioClienteApplication.class, args);
	}

}