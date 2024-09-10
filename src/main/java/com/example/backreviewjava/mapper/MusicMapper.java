package com.example.backreviewjava.mapper;

import com.example.backreviewjava.model.MusicModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MusicMapper {
    @Insert("insert into music (id, name, singer, album, date) values (#{id}, #{name}, #{singer}, #{album}, #{date})")
    void insert(MusicModel music);
}
