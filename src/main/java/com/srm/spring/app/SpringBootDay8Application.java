package com.srm.spring.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
/*@Configuration
@EnableAutoConfiguration
@ComponentScan*/
public class SpringBootDay8Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDay8Application.class, args);
	}

}
