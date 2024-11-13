package com.example.backreviewjava.service.impl;

import com.example.backreviewjava.dto.PaginationMybatisMusicDTO;
import com.example.backreviewjava.jpa.entity.MusicCustomSampleJpaEntity;
import com.example.backreviewjava.jpa.entity.MusicJpaEntity;
import com.example.backreviewjava.jpa.entity.ViewSingerMusicJpaEntity;
import com.example.backreviewjava.jpa.repository.MusicJpaRepository;
import com.example.backreviewjava.jpa.repository.SingerJpaRepository;
import com.example.backreviewjava.jpa.repository.ViewSingerMusicRepository;
import com.example.backreviewjava.service.ViewSingerMusicJpaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class ViewSingerMusicJpaServiceImpl implements ViewSingerMusicJpaService {

    @PersistenceContext
    private EntityManager entityManager;

    private final ViewSingerMusicRepository viewSingerMusicRepository;

    @Autowired
    public ViewSingerMusicJpaServiceImpl(ViewSingerMusicRepository viewSingerMusicRepository) {
        this.viewSingerMusicRepository = viewSingerMusicRepository;
    }

    public PaginationMybatisMusicDTO<ViewSingerMusicJpaEntity> getAllSingerMusics() {


        String sql = "SELECT * FROM ViewSingerMusic";
        Query query = entityManager.createNativeQuery(sql);
        List<Object[]> resultList = query.getResultList();
        log.warn("resultList==========>" + resultList);


        List<ViewSingerMusicJpaEntity> musics = viewSingerMusicRepository.getAllSingerMusics();
        log.info("getAllSingerMusics==========>" + musics);

        Long total = viewSingerMusicRepository.count();

        PaginationMybatisMusicDTO data = new PaginationMybatisMusicDTO<ViewSingerMusicJpaEntity>().builder()
                .musics(Collections.singletonList(resultList))
                .total(total.intValue())
                .current(1)
                .pageSize(10)
                .build();

        return data;
    }
}
