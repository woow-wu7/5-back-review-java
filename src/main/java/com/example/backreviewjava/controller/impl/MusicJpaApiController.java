package com.example.backreviewjava.controller.impl;

import com.example.backreviewjava.config.DatabaseConfig;
import com.example.backreviewjava.controller.MusicJpaApi;
import com.example.backreviewjava.dto.PaginationMybatisMusicDTO;
import com.example.backreviewjava.jpa.entity.MusicJpaEntity;
import com.example.backreviewjava.service.MusicJpaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 1
// final
// - The 'final' keyword indicates the data is a constant.
// - 表示一个 常量，不能被修改


@RestController
@Slf4j
public class MusicJpaApiController implements MusicJpaApi {

    // The 'final' keyword indicates the data is a constant.
    private final MusicJpaService musicJpaService;
    private final DatabaseConfig databaseConfig;

    // Inject multiple classes.
    @Autowired
    public MusicJpaApiController(MusicJpaService musicJpaService, DatabaseConfig databaseConfig) {
        this.musicJpaService = musicJpaService;
        this.databaseConfig = databaseConfig;
    }


    // 1
    // getAllMusics
    public PaginationMybatisMusicDTO<MusicJpaEntity> getAllMusics() {
        log.warn("getAllMusic==========>MusicJpaApiController/getAllMusics");
        log.warn("databaseConfig: this log is used to learn '@ConfigurationProperties' in 'DatabaseConfig' file {}", databaseConfig.toString());
        return musicJpaService.getAllMusics();
    }

    // 1
    // getMusicById
    public MusicJpaEntity getMusicById(@PathVariable Integer id) {
        log.warn("getAllMusic==========>MusicJpaApiController/getMusicById/id={}", id);
        return musicJpaService.getMusicById(id);
    }

    // 1
    // getMusicsByIds
    public PaginationMybatisMusicDTO<MusicJpaEntity> getMusicsByIds(@RequestParam String ids) {
        log.warn("getMusicsByIds==========>MusicJpaApiController/getMusicsByIds/ids={}", ids);

        // 1
        // Arrays.stream()
        // - .map(Integer::parseInt) => 这里是将 每个 ( String ) 类型的数据 通过 ( parseInt ) 方法转成 ( Integer ) 类型
        // - .map(Boolean::parseBoolean) => String -> Boolean
        // - .map(String::toUpperCase) => 将字符串转换为大写
        // - .map(Person::fromString) => 假设你有一个 Person 类，并且有一个方法 fromString 可以将字符串转换为 Person 对象
        List<Integer> musicIds = Arrays.stream(ids.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // 2
        // Stream.of()
        // - 这样也是也可的
        List<Integer> musicIds2 = Stream.of(ids.split(",")).map(Integer::parseInt)
                .collect(Collectors.toList());

        log.warn("musicIds=============>: {}", musicIds);
        log.warn("musicIds2=============>: {}", musicIds2);

        return musicJpaService.getMusicsByIds(musicIds);
    }

    // 1
    // 跨表查询 singer_id => table singer id
    // music(singer_id) => singer(id)
    public PaginationMybatisMusicDTO<MusicJpaEntity> getMusicBySinger(@RequestParam Integer singerId) {
        return musicJpaService.getMusicBySinger(singerId);
    }

    // 1
    public List<MusicJpaEntity> searchMusic(@RequestParam String keyword) {
        log.warn("searchMusic==========>MusicJpaApiController/searchMusic/keyword={}", keyword);
        return musicJpaService.searchMusic(keyword);
    }


    // 2
    // addMusic
    public void addMusic(@RequestBody MusicJpaEntity music) {
        log.warn("addMusic==========>MusicJpaApiController/addMusic/music={}", music);
        musicJpaService.addMusic(music);
    }

    // 3
    // editMusic
    public void editMusic(@RequestBody MusicJpaEntity music) {
        log.warn("editMusic==========>MusicJpaApiController/editMusic/music={}", music);
        musicJpaService.editMusic(music);
    }

    // 4
    public void deleteMusic(@PathVariable Integer id) {
        log.warn("deleteMusic==========>MusicJpaApiController/deleteMusic/id={}", id);
        musicJpaService.deleteMusic(id);
    }


//
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable Long id) {
//        Optional<User> user = userService.getUserById(id);
//        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public User createUser(@RequestBody User user) {
//        return userService.saveUser(user);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//        userService.deleteUser(id);
//        return ResponseEntity.noContent().build();
//    }
}
