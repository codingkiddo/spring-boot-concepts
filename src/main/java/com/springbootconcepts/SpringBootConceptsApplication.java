package com.springbootconcepts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.springbootconcepts")
public class SpringBootConceptsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConceptsApplication.class, args);
	}

}
