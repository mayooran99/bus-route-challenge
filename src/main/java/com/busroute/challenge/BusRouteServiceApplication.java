package com.busroute.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;

import java.io.File;

/**
 * Main class conforming to the Spring boot specifications
 */
@SpringBootApplication
public class BusRouteServiceApplication {

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(BusRouteServiceApplication.class);
        springApplication.addListeners(new ApplicationPidFileWriter());
        springApplication.run(args);
    }
}
