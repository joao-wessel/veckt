package com.veckt.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VecktBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(VecktBackendApplication.class, args);
    }
}
