package com.github.mickeydluffy.observability;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.security.KeyFactory;

@SpringBootApplication
@EnableCaching
public class ObservabilityApplication {

    public static void main(String[] args) {

        SpringApplication.run(ObservabilityApplication.class, args);
    }

}
