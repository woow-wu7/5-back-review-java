package com.example.backreviewjava.demos.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MusicController {

    @GetMapping("/music")
    public String getMusic() {
        return "Welcome to the music page!";
    }
}