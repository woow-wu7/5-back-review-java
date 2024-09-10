package com.example.backreviewjava.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class MusicModel {
    public Integer id;
    public String name;
    public String album;
    public String singer;
    public Date date;
}
