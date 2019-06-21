package com.web.service.server.SOPARESTwebserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ws.config.annotation.EnableWs;

@SpringBootApplication
@EntityScan
public class SopaRestWebServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SopaRestWebServerApplication.class, args);
	}

}
