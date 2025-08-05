package org.example.serviceregistery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicrossApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrossApplication.class, args);
	}

}
