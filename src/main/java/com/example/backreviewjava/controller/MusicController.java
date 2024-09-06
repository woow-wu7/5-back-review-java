package com.example.backreviewjava.controller;

import com.example.backreviewjava.bean.MusicBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Date;



// 1
// @RequestMapping 可以映射任何 HTTP 方法（GET、POST、PUT、DELETE 等）。
// @GetMapping 专门用于映射 HTTP GET 请求。

// 2
// parameters
// - path parameters
// - query parameters
// - request header parameters

@RestController
@RequestMapping("/api")
public class MusicController {

    @Autowired
    public MusicBean musicBean;

    //    @GetMapping("/name")
    //    @RequestMapping(value = "/music", method = RequestMethod.GET, params = "name,age")
    @GetMapping("/music")
    public String getMusic(@RequestParam(required = false) String name, @RequestParam(defaultValue = "18") Integer age) {
        return musicBean.builder()
                .name(name)
                .singer("wu99")
                .age(age)
                .time(new Date())
                .build().toString();
    }
}