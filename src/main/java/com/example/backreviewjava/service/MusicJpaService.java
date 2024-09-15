package com.example.backreviewjava.service;

import com.example.backreviewjava.jpa.entity.MusicJpaEntity;
import com.example.backreviewjava.service.impl.MusicJpaServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.zip.Inflater;

public interface MusicJpaService {
    public List<MusicJpaEntity> getAllMusics();

    public  MusicJpaEntity getMusicById(Integer id);

    public void addMusic(MusicJpaEntity music);
}
