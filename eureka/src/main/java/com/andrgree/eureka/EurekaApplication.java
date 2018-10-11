package com.andrgree.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(5_000L);
		SpringApplication.run(EurekaApplication.class, args);
	}
}
