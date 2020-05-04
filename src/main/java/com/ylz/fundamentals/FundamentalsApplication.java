package com.ylz.fundamentals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentalsApplication {

	private static final Logger log = LoggerFactory.getLogger(FundamentalsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FundamentalsApplication.class, args);
	}
}

/**
 * @SpringBootApplication
 *   @SpringBootConfiguration: Replaces @Configuration and annotates a class as a configuration
 * 	 @EnableAutoConfiguration: Tells Spring Boot to configure beans
 *   @ComponentScan: Tells Spring Boot to scan current package and subpackages
 */
