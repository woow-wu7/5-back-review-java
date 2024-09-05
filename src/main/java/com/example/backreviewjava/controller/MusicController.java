package com.example.backreviewjava.controller;

import com.example.backreviewjava.bean.MusicBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
public class MusicController {

    @Autowired
    public MusicBean musicBean;

    @GetMapping("/music")
    public String getMusic(String name) {
        return musicBean.builder()
                .name(name)
                .singer("wu99")
                .time(new Date())
                .build().toString();
    }
}