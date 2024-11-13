package com.example.backreviewjava.jpa.repository;

import com.example.backreviewjava.jpa.entity.MusicJpaEntity;
import com.example.backreviewjava.jpa.entity.ViewSingerMusicJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewSingerMusicRepository extends JpaRepository<ViewSingerMusicJpaEntity, Integer> {

    @Query("SELECT v FROM ViewSingerMusicJpaEntity v")
    List<ViewSingerMusicJpaEntity> getAllSingerMusics();
}
