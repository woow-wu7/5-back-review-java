package com.example.backreviewjava.controller.impl;

import com.example.backreviewjava.controller.MusicJpaApi;
import com.example.backreviewjava.jpa.entity.MusicJpaEntity;
import com.example.backreviewjava.service.MusicJpaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 1
// final
// - The 'final' keyword indicates the data is a constant.
// - 表示一个 常量，不能被修改


@RestController
@Slf4j
public class MusicJpaApiController implements MusicJpaApi {

    // The 'final' keyword indicates the data is a constant.
    private final MusicJpaService musicJpaService;
    @Autowired
    public MusicJpaApiController(MusicJpaService musicJpaService) {
        this.musicJpaService = musicJpaService;
    }


    // 1
    // getAllMusics
    public List<MusicJpaEntity> getAllMusics() {
        log.warn("getAllMusic==========>MusicJpaApiController/getAllMusics");
        return musicJpaService.getAllMusics();
    }

    // 2
    // getMusicById
    public MusicJpaEntity getMusicById(@PathVariable Integer id) {
        log.warn("getAllMusic==========>MusicJpaApiController/getMusicById/id={}", id);
        return musicJpaService.getMusicById(id);
    };


    // 3
    // addMusic
    public void addMusic(@RequestBody MusicJpaEntity music) {
        log.warn("addMusic==========>MusicJpaApiController/addMusic/music={}", music);
        musicJpaService.addMusic(music);
    }

    // 4
    // editMusic
    public void editMusic(@RequestBody MusicJpaEntity music) {
        log.warn("editMusic==========>MusicJpaApiController/editMusic/music={}", music);
        musicJpaService.editMusic(music);
    }

    // 5
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