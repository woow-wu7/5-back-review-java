package com.example.backreviewjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// 1
// ComponentScan
// - 这里 @ComponentScan 用来告诉springboot 去哪里找 controller

// 2
// @MapperScan()
// - 是 Mybatis 的注解，用来告诉springboot 去哪里找 mapper

@SpringBootApplication
public class BackReviewJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackReviewJavaApplication.class, args);
    }

}
