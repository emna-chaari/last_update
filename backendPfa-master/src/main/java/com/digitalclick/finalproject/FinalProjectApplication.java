package com.digitalclick.finalproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.digitalclick.finalproject.mapper","com.digitalclick.finalproject.controller", "com.digitalclick.finalproject.service", "com.digitalclick.finalproject.repository"} )
public class FinalProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalProjectApplication.class, args);
    }

}
