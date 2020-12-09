package com.service.microservice;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static org.springframework.boot.SpringApplication.*;

@SpringBootApplication
@EnableSwagger2
public class MicroserviceApplication {

	public static void main(String[] args) {
		run(MicroserviceApplication.class, args);
	}

}
