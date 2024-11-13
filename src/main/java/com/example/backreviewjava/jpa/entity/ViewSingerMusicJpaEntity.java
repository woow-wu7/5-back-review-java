package com.example.backreviewjava.jpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ViewSingerMusic")
public class ViewSingerMusicJpaEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "musicID", nullable = true) // can be null.
    public Integer musicID;

    @Column(name = "singerID", nullable = true) // can be null.
    public Integer singerID;

    @Column(name = "singerName", nullable = true) // can be null.
    public String singerName;

    @Column(name = "age", nullable = true) // can be null.
    public Integer age;

    @Column(name = "gender", nullable = true) // can be null.
    public String gender;

    @Column(name = "musicName", nullable = true) // can be null.
    public String musicName;

    @Column(name = "album", nullable = true) // can be null.
    public String album;

    @Column(name = "date", nullable = true)
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    public Date date;
}
