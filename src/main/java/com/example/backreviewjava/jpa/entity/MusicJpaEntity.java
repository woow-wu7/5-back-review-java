package com.example.backreviewjava.jpa.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

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

//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString // 以上都是 lombok的注解
//@JsonPropertyOrder({"name", "singer", "album", "date"}) // 以上是 swagger3 的注解
//@Slf4j
//@Component
@Entity
@Table(name = "music")
public class MusicJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    // @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer id;

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
    public String music_name;

    // @JsonIgnore // ignore this field
    public String album;

    @JsonProperty("music_singer")
    public String singer;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    public Date date;
}
