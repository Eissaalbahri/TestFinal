package com.example.testfinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class TestFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestFinalApplication.class, args);
	}

}
