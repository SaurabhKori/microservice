package com.sk.hotel_microservice_registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HotelMicroserviceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelMicroserviceRegistryApplication.class, args);
	}

}
