package com.abbreviator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AbbreviatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbbreviatorApplication.class, args);
	}

}
