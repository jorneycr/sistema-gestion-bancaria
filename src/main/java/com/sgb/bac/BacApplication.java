package com.sgb.bac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.sgb.bac.repository") 
public class BacApplication {

	public static void main(String[] args) {
		SpringApplication.run(BacApplication.class, args);
	}

}
