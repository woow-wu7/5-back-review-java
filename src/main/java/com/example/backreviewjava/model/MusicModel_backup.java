//package com.example.backreviewjava.model;
//
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//import lombok.*;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//import javax.persistence.*;
//import java.util.Date;
//
//
//
//// 注意:
//// - 1. 本文件学习 ( JPA  )
//// - 2. 学习 ( swagger3 ) ( lombok 注解 ) 请到 ( beam/MusicTestBean )
//
//
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
////@Slf4j
////@ToString // 以上都是 lombok的注解
////@JsonPropertyOrder({"name", "singer", "album", "date"}) // 以上是 swagger3 的注解
////@Component
//@Entity
//@Table(name = "music")
//public class Music {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    @JsonInclude(JsonInclude.Include.NON_NULL)
//    public Integer id;
//
//    public String name;
//
//    // @JsonIgnore // ignore this field
//    public String album;
//
//    @JsonProperty("music_singer")
//    public String singer;
//
//    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
//    public Date date;
//}
