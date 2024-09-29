package com.example.backreviewjava.config;

import com.example.backreviewjava.interceptor.RequestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 1
// 这里是 注册拦截器 register
@Configuration
public class WebConfig  implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestInterceptor())
                .addPathPatterns("/**") // 拦截 => 拦截所有请求，包括静态资源
                .excludePathPatterns("/", "/login", "css/**", "/fonts/**", "/images/**", "/js/**"); // 放行，放行了static文件夹下的所有静态资源
        // 问题：如何能访问到 resources/static/images/8.jpg
        // 回答：http://localhost:7777/images/8.jpg
    }

}


