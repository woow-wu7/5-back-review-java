package com.example.backreviewjava.controller;

import com.example.backreviewjava.PaginationDTO.PaginationMybatisMusicDTO;
import com.example.backreviewjava.mapper.MusicMybatisMapper;
import com.example.backreviewjava.model.MusicMybatisModel;
import com.example.backreviewjava.service.MusicMybatisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/music-mybatis-api")
public class MusicMybatisController {

    private final PaginationMybatisMusicDTO paginationMybatisMusicDTO;
    @Autowired
    public MusicMybatisController (PaginationMybatisMusicDTO paginationMybatisMusicDTO)   {
        this.paginationMybatisMusicDTO = paginationMybatisMusicDTO;
    }
    // 以下两行代码使用 上面代码代替就不会有warning
    // @Autowired
    // PaginationMybatisMusicDTO paginationMybatisMusicDTO;

    @Autowired
    MusicMybatisService musicMybatisService;

    @GetMapping("music")
    public  PaginationMybatisMusicDTO getAllMusics() {
        PaginationMybatisMusicDTO musics = musicMybatisService.selectAllMusics();
        log.warn(musics.toString());
        return musics;
    }

}
