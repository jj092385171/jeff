package com.campingmapping.team4.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CampingmappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampingmappingApplication.class, args);
	}

}
