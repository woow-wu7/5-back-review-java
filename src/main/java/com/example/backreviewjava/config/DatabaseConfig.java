package com.example.backreviewjava.config;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.datasource") // ---- 1. the 【 above 】 two 【 annotations 】 are used for attribute binding.
@Data // ----------------------------------------------------- 2. The【 following 】 four annotations are the functions of lombok.
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DatabaseConfig {
    private String username;
    private String password;
}
