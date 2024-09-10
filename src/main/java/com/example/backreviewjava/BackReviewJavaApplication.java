package com.example.backreviewjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// 1
// 问题：如何运行整个程序？
// 回答：只需要运行 Application 中的 main 方法即可

// 2
// 包结构
// - 注意：SpringBoot项目中，所有的包都必须是 ( 主程序所在的包 ) 的 ( 同级 或者 子级 ) 才会生效
// - 比如：( controller包 ) 就只能放在和 主程序Application 所在的包 ( com.example.backreviewjava ) 的 ( 同一层级 或者 子级 )
// - 问题：如果非要不同一层级或子级怎么设置呢？
// - 回答：@SpringBootApplication(scanBasePackages = "com.example") 来指定更大的范围，这里表示 com.example 下的所有包 || @ComponentScan

// 3
// @SpringBootApplication
// - 表示是一个 SpringBoot 应用
// - 主程序类，启动类，项目的入口

// 4
// @MapperScan
// - mybatis-plus 的注解
// - 指定mapper的目录，将自动扫描，则不用在每个类上都加@Mapper
// - 是 Mybatis 的注解，用来告诉springboot 去哪里找 mapper
// - @MapperScan("com.example.backreviewjava")

// 5
// ComponentScan
// - 这里 @ComponentScan 用来告诉springboot 去哪里找 controller

@SpringBootApplication(scanBasePackages = {"com.example.backreviewjava"})
//@EnableJpaRepositories
//@EntityScan("com.example.backreviewjava.model") // 添加此行
public class BackReviewJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackReviewJavaApplication.class, args);
    }

}
