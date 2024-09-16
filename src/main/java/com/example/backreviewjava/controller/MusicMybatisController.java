package com.example.backreviewjava.controller;

import com.example.backreviewjava.bean.MusicTestBean;
import com.example.backreviewjava.dto.PaginationMybatisMusicDTO;
import com.example.backreviewjava.service.MusicMybatisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/music-mybatis-api")
public class MusicMybatisController {

    private final PaginationMybatisMusicDTO<MusicTestBean> paginationMybatisMusicDTO;
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
