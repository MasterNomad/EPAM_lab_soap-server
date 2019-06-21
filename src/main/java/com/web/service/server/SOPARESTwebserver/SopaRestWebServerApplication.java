package com.web.service.server.SOPARESTwebserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class SopaRestWebServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SopaRestWebServerApplication.class, args);
    }

}
