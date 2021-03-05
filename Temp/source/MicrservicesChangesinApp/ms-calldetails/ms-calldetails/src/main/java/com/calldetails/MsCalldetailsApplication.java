package com.calldetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsCalldetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCalldetailsApplication.class, args);
	}

}
