package com.nikhilrana.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
Used when we have to do component scanning for packages lying outside of the main package
@SpringBootApplication(
		scanBasePackages = {"com.nikhilrana.springcoredemo",
							"com.nikhilrana.util"}
)
*/
@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
