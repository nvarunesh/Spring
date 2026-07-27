package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = { "com.*" })
@EnableScheduling
@EnableCaching
@EnableAsync
public class ApplicationStartUp {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationStartUp.class, args);
		System.err.println("Started");
	}

}
