package com.clinet.add;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication

@ComponentScan(basePackages={"com.clinet.add.*"})
@EnableDiscoveryClient
public class EurekaClientAddApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientAddApplication.class, args);
	}

}
