package com.example.backreviewjava.service;

import com.example.backreviewjava.dto.PaginationMybatisMusicDTO;
import com.example.backreviewjava.jpa.entity.MusicJpaEntity;
import com.example.backreviewjava.jpa.entity.ViewSingerMusicJpaEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ViewSingerMusicJpaService {
    public PaginationMybatisMusicDTO<ViewSingerMusicJpaEntity> getAllSingerMusics();
}
