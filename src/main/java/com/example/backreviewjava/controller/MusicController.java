package com.example.backreviewjava.controller;

import com.example.backreviewjava.mapper.MusicMapper;
import com.example.backreviewjava.model.MusicModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class MusicController {

    @Autowired
    MusicMapper musicMapper;

    @GetMapping("/music")
    public MusicModel getMusic() {
        MusicModel music = new MusicModel();
        music.setId(4);
        music.setName("七里香4");
        music.setAlbum("叶惠美4");
        music.setSinger("周杰伦4");
        music.setDate(new Date());

        musicMapper.insert(music);

        return music;
    }

}
