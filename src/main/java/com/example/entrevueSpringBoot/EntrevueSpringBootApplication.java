package com.example.entrevueSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.entrevueSpringBoot.controller")
public class EntrevueSpringBootApplication {

	public static void main(String[] args) {

		SpringApplication.run(EntrevueSpringBootApplication.class, args);
	}

}
