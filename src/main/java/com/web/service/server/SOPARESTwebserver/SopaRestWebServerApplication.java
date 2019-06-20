package com.web.service.server.SOPARESTwebserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ws.config.annotation.EnableWs;

@SpringBootApplication
public class SopaRestWebServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SopaRestWebServerApplication.class, args);
	}

}
