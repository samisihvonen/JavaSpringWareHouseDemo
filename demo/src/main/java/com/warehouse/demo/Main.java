package com.warehouse.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableMongoRepositories
@RestController
@RequiredArgsConstructor
public class Main {
	public static void main(String[] args) {


		SpringApplication.run(Main.class, args);
	}

}
