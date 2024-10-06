package com.example.backreviewjava.service;

import com.example.backreviewjava.dto.PaginationMybatisMusicDTO;
import com.example.backreviewjava.jpa.entity.MusicJpaEntity;
import com.example.backreviewjava.service.impl.MusicJpaServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.zip.Inflater;

public interface MusicJpaService {
    public PaginationMybatisMusicDTO<MusicJpaEntity> getAllMusics();

    public  MusicJpaEntity getMusicById(Integer id);

    public PaginationMybatisMusicDTO<MusicJpaEntity> getMusicsByIds(List<Integer> musicIds);

    // 1
    // 跨表查询 singer_id => table singer id
    // music(singer_id) => singer(id)
    public  PaginationMybatisMusicDTO<MusicJpaEntity> getMusicBySinger(Integer singerId);

    public List<MusicJpaEntity> searchMusic(String keyword);

    public void addMusic(MusicJpaEntity music);

    public void editMusic(MusicJpaEntity music);

    public void deleteMusic(Integer id);


}
