
package com.example.backreviewjava.service.impl;

import com.example.backreviewjava.dto.PaginationMybatisMusicDTO;
import com.example.backreviewjava.jpa.entity.SingerJpaEntity;
import com.example.backreviewjava.jpa.repository.MusicJpaRepository;
import com.example.backreviewjava.jpa.entity.MusicJpaEntity;
import com.example.backreviewjava.jpa.repository.SingerJpaRepository;
import com.example.backreviewjava.service.MusicJpaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class MusicJpaServiceImpl implements MusicJpaService {

    private final MusicJpaRepository musicJpaRepository;
    private final SingerJpaRepository singerJpaRepository;
    // @Resource
    @Autowired
    public MusicJpaServiceImpl(MusicJpaRepository musicJpaRepository, SingerJpaRepository singerJpaRepository) {
        this.musicJpaRepository = musicJpaRepository;
        this.singerJpaRepository = singerJpaRepository;
    }

    // 1
    // findAll()
    public PaginationMybatisMusicDTO<MusicJpaEntity> getAllMusics() {
        log.warn("getAllMusic==========>MusicJpaServiceImpl/musicJpaRepository/findAll");

        List<MusicJpaEntity> musics = musicJpaRepository.findAll();
        Long total = musicJpaRepository.count();

        PaginationMybatisMusicDTO data = new PaginationMybatisMusicDTO<MusicJpaEntity>().builder()
                .musics(Collections.singletonList(musics))
                .total(total.intValue())
                .current(1)
                .pageSize(10)
                .build();

        return data;
    }

    // 1
    // findById(id).get()
    public MusicJpaEntity getMusicById(Integer id) {
        return musicJpaRepository.findById(id).get();
    }

    // 1
    // findByInIn(ids)
    public PaginationMybatisMusicDTO<MusicJpaEntity> getMusicsByIds(List<Integer> musicIds) {

        List<MusicJpaEntity> musics = musicJpaRepository.findByIdIn(musicIds);
        Long total = musicJpaRepository.count();

        log.warn("getMusicsByIds==========>MusicJpaServiceImpl/getMusicsByIds/musics={}", musics);

        PaginationMybatisMusicDTO data = new PaginationMybatisMusicDTO<MusicJpaEntity>().builder()
                .musics(Collections.singletonList(musics))
                .total(total.intValue())
                .current(1)
                .pageSize(10)
                .build();

        return data;
    }

    // 1
    // 跨表查询 singer_id => table singer id
    // music(singer_id) => singer(id)
    public PaginationMybatisMusicDTO<MusicJpaEntity> getMusicBySinger(Integer singerId) {

        SingerJpaEntity singer = singerJpaRepository.findById(singerId);
        log.warn("getMusicByIds==========>MusicJpaServiceImpl/get:【singerName】:{}", singer);

        List<MusicJpaEntity> musics =  musicJpaRepository.findBySinger(singer);
        Long total = musicJpaRepository.count();
        PaginationMybatisMusicDTO data = new PaginationMybatisMusicDTO<MusicJpaEntity>().builder()
                .musics(Collections.singletonList(musics))
                .total(total.intValue())
                .current(1)
                .pageSize(10)
                .build();
        return data;
    }


    // 1
    // searchByKeyword(keyword)
    public List<MusicJpaEntity> searchMusic(String keyword) {
        return musicJpaRepository.searchByKeyword(keyword);
    }

    // 2
    // save() - add
    public void addMusic(MusicJpaEntity music) {
        log.warn("addMusic{}", music);
        musicJpaRepository.save(music);
    }

    // 3
    // save() - edit
    public void editMusic(MusicJpaEntity music) {
        log.warn("editMusic{}", music);
        musicJpaRepository.save(music);
    }

    // 4
    // deleteById
    public void deleteMusic(Integer id) {
        log.warn("deleteMusic==========>MusicJpaServiceImpl/deleteMusic/id={}", id);
        musicJpaRepository.deleteById(id);
    }

}
