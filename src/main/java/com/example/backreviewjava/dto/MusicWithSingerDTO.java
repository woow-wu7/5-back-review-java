package com.example.backreviewjava.dto;

import java.util.Date;

public class MusicWithSingerDTO {
    private Integer musicId;
    private String musicName;
    private String album;
    private Date date;
    private Integer singerId;
    private String singerName;

    // 构造函数
    public MusicWithSingerDTO(Integer musicId, String musicName, String album, Date date, Integer singerId, String singerName) {
        this.musicId = musicId;
        this.musicName = musicName;
        this.album = album;
        this.date = date;
        this.singerId = singerId;
        this.singerName = singerName;
    }

    // Getters and Setters
}
