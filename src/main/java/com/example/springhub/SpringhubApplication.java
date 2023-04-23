package com.example.springhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringhubApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringhubApplication.class, args);
	}

}
