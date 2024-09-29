package com.example.backreviewjava.config;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.datasource") // the two annotations are used to attribute binding.
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor // The four annotations are the functions of lombok.
public class DatabaseConfig {
    private String username;
    private String password;
}
