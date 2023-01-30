package com.acc.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
//		System.setProperty("server.servlet.context-path", "/books");
		SpringApplication.run(ExampleApplication.class, args);
	}

}
