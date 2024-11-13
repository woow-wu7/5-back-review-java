package com.example.backreviewjava.controller.impl;


import com.example.backreviewjava.config.DatabaseConfig;
import com.example.backreviewjava.controller.ViewSingerMusicJpaApi;
import com.example.backreviewjava.dto.PaginationMybatisMusicDTO;
import com.example.backreviewjava.jpa.entity.MusicJpaEntity;
import com.example.backreviewjava.jpa.entity.ViewSingerMusicJpaEntity;
import com.example.backreviewjava.service.MusicJpaService;
import com.example.backreviewjava.service.ViewSingerMusicJpaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ViewSingerMusicJpaApiController implements ViewSingerMusicJpaApi {
    // 1
    // getAllSingerMusics

    ViewSingerMusicJpaService viewSingerMusicJpaService;

    // Inject service.
    @Autowired
    public ViewSingerMusicJpaApiController( ViewSingerMusicJpaService viewSingerMusicJpaService) {
        this.viewSingerMusicJpaService = viewSingerMusicJpaService;
    }

    public PaginationMybatisMusicDTO<ViewSingerMusicJpaEntity> getAllSingerMusics() {
        return viewSingerMusicJpaService.getAllSingerMusics();
    }

}
