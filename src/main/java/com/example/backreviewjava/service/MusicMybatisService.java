package com.example.backreviewjava.service;


import com.example.backreviewjava.dto.PaginationMybatisMusicDTO;
import com.example.backreviewjava.mapper.MusicMybatisMapper;
import com.example.backreviewjava.model.MusicMybatisModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MusicMybatisService {

    @Autowired
    PaginationMybatisMusicDTO paginationMybatisMusicDTO;

    @Autowired
    MusicMybatisMapper musicMybatisMapper;

    // 1
    public PaginationMybatisMusicDTO  selectAllMusics () {
        List<MusicMybatisModel> totalMusics = musicMybatisMapper.selectAllMusics(); // 总数据是为了获取 total
        PaginationMybatisMusicDTO paginationMybatisMusicDTO = new PaginationMybatisMusicDTO();
        paginationMybatisMusicDTO.musics = totalMusics;
        return paginationMybatisMusicDTO;
    }

}
