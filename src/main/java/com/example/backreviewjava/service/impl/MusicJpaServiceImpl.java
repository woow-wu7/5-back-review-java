
package com.example.backreviewjava.service.impl;

import com.example.backreviewjava.dto.MusicWithSingerDTO;
import com.example.backreviewjava.dto.PaginationMybatisMusicDTO;
import com.example.backreviewjava.jpa.entity.MusicCustomSampleJpaEntity;
import com.example.backreviewjava.jpa.entity.SingerJpaEntity;
import com.example.backreviewjava.jpa.repository.MusicJpaRepository;
import com.example.backreviewjava.jpa.entity.MusicJpaEntity;
import com.example.backreviewjava.jpa.repository.SingerJpaRepository;
import com.example.backreviewjava.service.MusicJpaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class MusicJpaServiceImpl implements MusicJpaService {

    // @PersistenceContext
    // - @PersistenceContext 是 JPA（Java Persistence API）中的一个注解，用于将 EntityManager 注入到你的服务类中。
    // - 这种方式通常用于 Spring 应用程序中，Spring 会自动管理 EntityManager 的生命周期
    @PersistenceContext
    private EntityManager entityManager;

    private final MusicJpaRepository musicJpaRepository;
    private final MusicCustomSampleJpaEntity musicCustomSampleJpaEntity;

    //    private final SingerJpaRepository singerJpaRepository;
    // @Resource
    @Autowired
    public MusicJpaServiceImpl(MusicJpaRepository musicJpaRepository, SingerJpaRepository singerJpaRepository, MusicCustomSampleJpaEntity musicCustomSampleJpaEntity) {
        this.musicJpaRepository = musicJpaRepository;
        this.musicCustomSampleJpaEntity = musicCustomSampleJpaEntity;
//        this.singerJpaRepository = singerJpaRepository;
    }

    // 1
    // findAll()
    public PaginationMybatisMusicDTO<MusicJpaEntity> getAllMusics() {
        log.warn("getAllMusic==========>MusicJpaServiceImpl/musicJpaRepository/findAll");

        List<MusicJpaEntity> musics = musicJpaRepository.findAll();
        Long total = musicJpaRepository.count();

        PaginationMybatisMusicDTO data = new PaginationMybatisMusicDTO<MusicJpaEntity>().builder()
                .musics(Collections.singletonList(musics))
                .total(total.intValue())
                .current(1)
                .pageSize(10)
                .build();

        return data;
    }

    // 1
    // findById(id).get()
    public MusicJpaEntity getMusicById(Integer id) {
        return musicJpaRepository.findById(id).get();
    }

    // 1
    // 【 getAllMusicsThroughEntityManger 】!!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!!
    // 使用 EntityManager 来手动创建和执行查询的场景
    // - 简化开发：Spring Data JPA 提供了许多内置的方法，如 findAll()、findById()、save() 等，可以大大简化数据访问层的开发。
    // - 自动生成查询：你可以通过方法名约定来自动生成查询，例如 findByName(String name) 会自动生成一个根据 name 字段查询的查询语句。
    // - 适用于简单查询：当你需要处理简单的 CRUD 操作时，这种方式非常方便。
    // ---- 问题: JPA 有几种查询方式
    // ---- 1. JpaRepository 接口: 自动，简单
    // -----2. EntityManager: 手动创建和执行查询，更灵活，但需要更多的代码
    public List<MusicJpaEntity> getAllMusicsThroughEntityManger() {

        // 1
        // 创建 HQL 查询语句 Hibernate Query Language
        String hql = "SELECT a FROM MusicJpaEntity a";
        // 使用 EntityManager 创建查询对象
        Query query = entityManager.createQuery(hql, MusicJpaEntity.class);
        List<MusicJpaEntity> resultList = query.getResultList();
        log.warn("getAllMusicsThroughEntityManger==========>MusicJpaServiceImpl/getAllMusicsThroughEntityManger/query={}", query);
        log.warn("resultList000000000--{}:" + resultList);


        // 2
        // new
        // - function: Reduce the number of attributes/properties in the returned data.
        // - attribute = property 属性
        // - property 属性 财产 n
        // - returned 返回的 adj
        String sql2 = "SELECT new com.example.backreviewjava.jpa.entity.MusicCustomSampleJpaEntity(m.name, m.singer) FROM MusicJpaEntity m";
        Query query2 = entityManager.createQuery(sql2, MusicCustomSampleJpaEntity.class);
        List<MusicCustomSampleJpaEntity> resultList2 = query2.getResultList();
        log.warn("resultList1111111111--{}:" + resultList2);


        // 执行查询并返回结果
        return resultList;
    }


    // 1
    // 【 getMusicsByIds 】!!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!!
    // => findByIdIn => Select * from AAA where id in (1,2,3)
    public PaginationMybatisMusicDTO<MusicJpaEntity> getMusicsByIds(List<Integer> musicIds) {

        List<MusicJpaEntity> musics = musicJpaRepository.findByIdIn(musicIds);
        Long total = musicJpaRepository.count();

        log.warn("getMusicsByIds==========>MusicJpaServiceImpl/getMusicsByIds/musics={}", musics);

        PaginationMybatisMusicDTO data = new PaginationMybatisMusicDTO<MusicJpaEntity>().builder()
                .musics(Collections.singletonList(musics))
                .total(total.intValue())
                .current(1)
                .pageSize(10)
                .build();

        return data;
    }

    // 1
    // 【 getMusicBySinger 】!!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!!
    // 跨表查询 singer_id => table singer id
    // music(singer_id) => singer(id)
//    public PaginationMybatisMusicDTO<MusicJpaEntity> getMusicBySinger(Integer singerId) {
//
//        SingerJpaEntity singer = singerJpaRepository.findById(singerId);
//        log.warn("getMusicByIds==========>MusicJpaServiceImpl/get:【singerName】:{}", singer);
//
//        List<MusicJpaEntity> musics =  musicJpaRepository.findBySinger(singer);
//        Long total = musicJpaRepository.count();
//        PaginationMybatisMusicDTO data = new PaginationMybatisMusicDTO<MusicJpaEntity>().builder()
//                .musics(Collections.singletonList(musics))
//                .total(total.intValue())
//                .current(1)
//                .pageSize(10)
//                .build();
//        return data;
//    }


    @Transactional
    public PaginationMybatisMusicDTO<MusicJpaEntity> getAllMusicByForeignKey() {


        String hql2 = "SELECT NEW com.example.backreviewjava.dto.MusicWithSingerDTO(m.id, m.name, m.album, m.date, s.id, s.name) FROM MusicJpaEntity m, SingerJpaEntity s WHERE (m.singer_id === )";
        Query query2 = entityManager.createQuery(hql2, MusicJpaEntity.class);
        List<MusicWithSingerDTO> resultList2 = query2.getResultList();
        log.warn("resultList222222222--{}:" + resultList2);


//        String sql2 = "SELECT new com.example.backreviewjava.jpa.entity.MusicCustomSampleJpaEntity FROM MusicJpaEntity m OIN FETCH m.songSinger";
        String hql = "SELECT a FROM MusicJpaEntity a JOIN FETCH a.songSinger";
        Query query = entityManager.createQuery(hql, MusicJpaEntity.class);

//
        List<MusicJpaEntity> resultList = query.getResultList();
        log.warn("getAllMusicByForeignKey==========>", resultList);

        Long total = musicJpaRepository.count();
        PaginationMybatisMusicDTO data = new PaginationMybatisMusicDTO<MusicJpaEntity>().builder()
                .musics(Collections.singletonList(resultList))
                .total(total.intValue())
                .current(1)
                .pageSize(10)
                .build();

        return data;
    }


    // 1
    // 【 searchMusic 】 !!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!!
    // -- fuzzy query 模糊查询
    // -- => keyword
    public List<MusicJpaEntity> searchMusic(String keyword) {
        return musicJpaRepository.searchByKeyword(keyword);
    }

    // 2
    // save() - add
    public void addMusic(MusicJpaEntity music) {
        log.warn("addMusic{}", music);
        musicJpaRepository.save(music);
    }

    // 3
    // save() - edit
    public void editMusic(MusicJpaEntity music) {
        log.warn("editMusic{}", music);
        musicJpaRepository.save(music);
    }

    // 4
    // deleteById
    public void deleteMusic(Integer id) {
        log.warn("deleteMusic==========>MusicJpaServiceImpl/deleteMusic/id={}", id);
        musicJpaRepository.deleteById(id);
    }

}
