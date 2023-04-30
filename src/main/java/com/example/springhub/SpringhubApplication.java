package com.example.springhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
@EnableCassandraRepositories
//@EnableFeignClients
public class SpringhubApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringhubApplication.class, args);
	}

}
