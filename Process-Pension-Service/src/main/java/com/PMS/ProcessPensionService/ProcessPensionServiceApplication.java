package com.PMS.ProcessPensionService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class ProcessPensionServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProcessPensionServiceApplication.class, args);
	}

}
