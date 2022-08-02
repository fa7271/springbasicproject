package com.example.springbasicproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing
@SpringBootApplication
public class SpringbasicprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbasicprojectApplication.class, args);
	}

}
