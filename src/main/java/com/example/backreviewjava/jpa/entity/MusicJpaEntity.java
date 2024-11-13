package com.example.backreviewjava.jpa.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;



// 注意:
// - 1. 本文件学习 ( JPA  )
// - 2. 学习 ( swagger3 ) ( lombok 注解 ) 请到 ( beam/MusicTestBean )


// JPA
// 1. @Entity
// 2. @Table("music")
//
// 3. @Id
// 3. @GeneratedValue(strategy = GenerationType.IDENTITY)
//
// 4. @Column(name = "name", nullable = false, unique = true, length = 512)
// name: The 'name' represents the field that is mapped to the database.
// nullable: The 'nullable=false' means that the 'name' is not null.
// unique: The 'unique=true' field means this field is unique in the database.
// length: The 'length=512' field means the max length of this field is 512.
// TIPS: the 'music_name' field correspond to the 'name' field in the database.
// -- map: 地图n 映射v
// -- correspond: 对应 相当于 类似于
// -- 【 correspond to. 和...相对应 】

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@ToString // 以上都是 lombok的注解
//@JsonPropertyOrder({"name", "singer", "album", "date"}) // 以上是 swagger3 的注解
@Slf4j
//@Component
@Entity
@Table(name = "music")
public class MusicJpaEntity {
    // 1
    // GenerationType enumeration: TABLE, SEQUENCE, IDENTITY, AUTO;
    // nullable: It's means the attribute can not empty.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // identity
    @Column(name = "id", nullable = false, unique = true, length = 64)
    // @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer id;


    // 2
    //  music(singer_id) => singer(id)
    //  @ManyToOne ========================> 表示 ( 多个music ) 对 ( 1个singer )
    //  @JoinColumn(name = "singer_id") ===> 表示 ( 指定外键的列 ) 是 ( singer_id )
    // ---- ！！！！！！结合 SingerJpaEntity 中的 private List<MusicJpaEntity> musicList; 一起看！！！！！！！

//    @ManyToOne
//    @JoinColumn(name = "singer_id", nullable = false)
    // name = "singer_id 表示 ( 指定外键的列 ) 是 ( singer_id )
    // nullable = false 表示不能为 null // true 表示可以为null
    // ---- 【  @OneToMany(mappedBy = "singer", cascade = CascadeType.ALL)  】 和 【  private SingerJpaEntity singer 】
    // ---- 声明了一个新的属性 singer，这个是个外键对应的属性，MusicJpaEntity的singer属性并不在数据库的music表中，是新声明的
    // ---- singer 对应的外键是 singer_id
//    private SingerJpaEntity singer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false) // 使用 EAGER 加载策略
    @JoinColumn(name = "singer_id", nullable = true)
//    @NotFound(action = NotFoundAction.IGNORE) // 忽略不存在的 SingerJpaEntity
    private SingerJpaEntity songSinger;

    // 2
    // 这里通过 外键 后就不能再声明这一列了
    // @Column(name = "singer_id", nullable = true)
    // public Integer singer_id;

    // name
    // name: The 'name' represents the field that is mapped to the database.
    // nullable: The 'nullable=false' means that the 'name' is not null.
    // unique: The 'unique=true' field means this field is unique in the database.
    // length: The 'length=512' field means the max length of this field is 512.
    // TIPS: the 'music_name' field correspond to the 'name' field in the database.
    // -- map: 地图n 映射v
    // -- correspond: 对应 相当于 类似于
    // -- 【 correspond to. 和...相对应 】
    @Column(name = "name", nullable = false, unique = true, length = 512)
    public String name;

    // @JsonIgnore // ignore this field
    @Column(name = "album", nullable = true)
    public String album;

//     @Column(name = "singer", nullable = true)
//     @JsonProperty("music_singer")
//     public String singer;


    @Column(name = "date", nullable = true)
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    public Date date;
}
