package com.example.backreviewjava.jpa.repository;

import com.example.backreviewjava.jpa.entity.MusicJpaEntity;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MusicJpaRepository extends JpaRepository<MusicJpaEntity, Integer> {

    // 自定义 JPQL 查询，对 name, singer 和 album 进行模糊查询
    // -- 第一个 m 是别名代表的实体
    // -- 第二个 m 是给 MusicJpaEntity 去了一个别名
    @Query("SELECT m FROM MusicJpaEntity m WHERE " +
            "m.name LIKE %:keyword% OR " +
            "m.singer LIKE %:keyword% OR " +
            "m.album LIKE %:keyword%")
    List<MusicJpaEntity> searchByKeyword(@Param("keyword") String keyword);
}
