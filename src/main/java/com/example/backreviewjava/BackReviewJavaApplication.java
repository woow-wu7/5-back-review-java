package com.example.backreviewjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.backreviewjava.demos.web.controller")
public class BackReviewJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackReviewJavaApplication.class, args);
    }

}
