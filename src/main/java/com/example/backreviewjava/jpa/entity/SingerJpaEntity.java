package com.example.backreviewjava.jpa.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "singer")
public class SingerJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "name", nullable = true)
    public String name;

    @Column(name = "gender", nullable = true)
    public String gender;

    @Column(name = "age", nullable = true)
    public Integer age;


    // 1
    // 1.1. music(singer_id) => singer(id)
    // 1.2 mappedBy = "singer"：
    // -- 指定这段关系的“多”的一方（即 Music 实体）的属性名为 singer。
    // -- 这意味着 Music 中的 singer 属性是这段关系的所有者，musicList 是反向引用。
    // 1.3 cascade = CascadeType.ALL：
    // -- 表示在进行级联操作时，所有操作（如保存、删除等）都会传递到相关的 Music 实体。
    // -- 例如，如果删除一个 Singer，同时会删除与该歌手关联的所有 Music 实体。
    @OneToMany(mappedBy = "singer", cascade = CascadeType.ALL)
    private List<MusicJpaEntity> musicList;
}
