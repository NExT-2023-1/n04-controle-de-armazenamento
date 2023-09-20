package com.next2023.cloud_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }) 
public class CloudServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudServiceApplication.class, args);
	}

}
