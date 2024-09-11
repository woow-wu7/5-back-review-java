package com.example.backreviewjava.bean;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;


// 注意:
// - 1. 本文件学习 ( swagger3 ) ( lombok 注解 )
// - 2. 学习 ( JPA ) 请到 ( model/Musics )


// @Data
// - 是lombok的注解
// - @Data会自动生成 @Getter @Setter @ToString @EqualsAndHashCode @RequiredArgsConstructor

// @Builder
// - 通常情况下 @Data 和 @Builder 会一起使用，因为还是必须写getter/setter
// - 使用
//   - 在 HelloBean 中使用 @Builder
//   - 在 HelloController 中通过 hello2.builder().name("woow_wu7").age(100).build(); 来调用
// - 教程：https://juejin.cn/post/6960187616050282533#heading-21

// @Slf4j
// - @Slf4j 自动生成该类的 log 静态常量，所以不需要sout了
// - 使用：比如用在controller中 --- log.info("文件名{}. 大小{}KB", originalFilename, size);

// @Component
// - 将 Bean 注册为容器组件，具有 SpringBoot 的强大能力

// Jackson
// - @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
// - @JsonPropertyOrder({"name", "singer", "album",  "time"})
// - @JsonProperty("music_singer")
// - @JsonInclude(JsonInclude.Include.NON_NULL) // If the value is none, then it will not be return;
// - @JsonIgnore // Do not return this field

@Data
@Builder
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@ToString // 以上都是 lombok 的注解
@Component
@JsonPropertyOrder({"name", "singer", "album", "date"})
//@Entity // 表示是一个实体类，接受 jpa管理
//@Table(name = "musics")
public class MusicTestBean {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer id;

    public String name;

    // @JsonIgnore // ignore this field
    public String album;

    @JsonProperty("music_singer")
    public String singer;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    public Date date;
}
