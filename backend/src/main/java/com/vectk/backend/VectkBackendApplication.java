package com.vectk.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VectkBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(VectkBackendApplication.class, args);
    }
}
