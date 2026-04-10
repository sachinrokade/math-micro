package com.clinet.sub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.clinet.sub.*"})
@EnableDiscoveryClient
public class EurekaClientSubApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientSubApplication.class, args);
	}

}
