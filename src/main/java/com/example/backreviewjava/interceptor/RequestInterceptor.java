package com.example.backreviewjava.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;

@Component
@Slf4j
public class RequestInterceptor implements HandlerInterceptor {

    // 1
    // preHandle
    // 目标方法执行之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle拦截器 - HTTP Method: " + request.getMethod());
        System.out.println("preHandle拦截器 - Request URL: " + request.getRequestURL());
        System.out.println("preHandle拦截器 - Query Parameters: " + request.getQueryString());
        System.out.println("preHandle拦截器 - Request Parameters: " + request.getParameterMap());
        System.out.println("preHandle拦截器 - Request Headers: " + Collections.list(request.getHeaderNames()));
        return true; // true 表示放行，false表示拦截
    }

    // 2
    // postHandle
    // 目标方法执行完成之后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle拦截器 - Response Status: " + response.getStatus());
        System.out.println("postHandle拦截器 - Response Headers: " + response.getHeaderNames());
    }

    // 3
    // 页面渲染以后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion拦截器");
        if (ex != null) {
            // 错误信息
            System.out.println("afterCompletion拦截器 - Exception Occurred: " + ex.getMessage());
        }
    }

}
