package com.healthapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })

public class HealthBackEndApplication  {

    public static void main(String[] args) {
        SpringApplication.run(HealthBackEndApplication.class, args);
    }



}

