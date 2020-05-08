package com.ylz.fundamentals;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * @SpringBootApplication
 *   @SpringBootConfiguration: Replaces @Configuration and annotates a class as a configuration
 * 	 @EnableAutoConfiguration: Tells Spring Boot to configure beans
 *   @ComponentScan: Tells Spring Boot to scan current package and subpackages
 */

@SpringBootApplication
@Log4j2
public class FundamentalsApplication {
	//private static final Logger log = LoggerFactory.getLogger(FundamentalsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FundamentalsApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner (Environment environment,
										 @Value("${app.non-exist-property:default-value}") String defaultValue) {
		return new ApplicationRunner() {
			public void run(ApplicationArguments args) throws Exception {
				log.info(environment.getProperty("app.version") + ", " + environment.getProperty("app.env"));
			}
		};

//		return args -> {
//			log.info(environment.getProperty("app.version") + ", " + environment.getProperty("app.env"));
//		};
	}
}