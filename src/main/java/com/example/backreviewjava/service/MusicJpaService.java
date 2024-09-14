
package com.example.backreviewjava.service;

import com.example.backreviewjava.jpa.repository.MusicJpaRepository;
import com.example.backreviewjava.jpa.entity.MusicJpaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicJpaService {

    private final MusicJpaRepository musicJpaRepository;
    // @Resource
    @Autowired
    public MusicJpaService(MusicJpaRepository musicJpaRepository) {
        this.musicJpaRepository = musicJpaRepository;
    }

    public List<MusicJpaEntity> getAllMusics() {
        return musicJpaRepository.findAll();
    }

}
