

package com.humanitics.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class UserserviceApplication {
	@Bean
	@LoadBalanced
   public RestTemplate restTemplate() {
	   return new RestTemplate();
   }
	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

}
