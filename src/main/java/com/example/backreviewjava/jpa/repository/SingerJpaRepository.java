package com.example.backreviewjava.jpa.repository;

import com.example.backreviewjava.jpa.entity.SingerJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingerJpaRepository extends JpaRepository<SingerJpaEntity, Long> {
    // 1
    // music(singer_id) => singer(id)
    SingerJpaEntity findById(Integer singerId);
}