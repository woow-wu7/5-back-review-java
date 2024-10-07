package com.example.backreviewjava.service;

import com.example.backreviewjava.dto.PaginationMybatisMusicDTO;
import com.example.backreviewjava.jpa.entity.MusicJpaEntity;
import com.example.backreviewjava.service.impl.MusicJpaServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.zip.Inflater;

public interface MusicJpaService {
    public PaginationMybatisMusicDTO<MusicJpaEntity> getAllMusics();

    public  MusicJpaEntity getMusicById(Integer id);

    // 1
    // 【 getAllMusicsThroughEntityManger 】!!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!!
    // 使用 EntityManager 来手动创建和执行查询的场景
    // - 简化开发：Spring Data JPA 提供了许多内置的方法，如 findAll()、findById()、save() 等，可以大大简化数据访问层的开发。
    // - 自动生成查询：你可以通过方法名约定来自动生成查询，例如 findByName(String name) 会自动生成一个根据 name 字段查询的查询语句。
    // - 适用于简单查询：当你需要处理简单的 CRUD 操作时，这种方式非常方便。
    // ---- 问题: JPA 有几种查询方式
    // ---- 1. JpaRepository 接口: 自动，简单
    // -----2. EntityManager: 手动创建和执行查询，更灵活，但需要更多的代码
    public List<MusicJpaEntity> getAllMusicsThroughEntityManger();

    // 1List
    // 【 getMusicsByIds 】!!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!!
    // => findByIdIn => Select * from AAA where id in (1,2,3)
    public PaginationMybatisMusicDTO<MusicJpaEntity> getMusicsByIds(List<Integer> musicIds);

    // 1
    // 【 getMusicBySinger 】!!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!!
    // 跨表查询 singer_id => table singer id
    // music(singer_id) => singer(id)
//    public  PaginationMybatisMusicDTO<MusicJpaEntity> getMusicBySinger(Integer singerId);


    // 1
    // 【 searchMusic 】 !!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!!
    // -- fuzzy query 模糊查询
    // -- => keyword
    public List<MusicJpaEntity> searchMusic(String keyword);

    public void addMusic(MusicJpaEntity music);

    public void editMusic(MusicJpaEntity music);

    public void deleteMusic(Integer id);


}
