package com.rothys.envSpecific;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.rothys", "com.MulitThreading"})
@ComponentScan(basePackages = {"com.rothys", "com.MulitThreading", "com.MulitThreading.repository"})
@EntityScan(basePackages = {"com.MulitThreading"})
@EnableMongoRepositories(basePackages = {"com.MulitThreading.repository","com.rothys.envSpecific.repositories"})
@EnableAsync
@EnableScheduling
public class EnvSpecificApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnvSpecificApplication.class, args);
	}

}
