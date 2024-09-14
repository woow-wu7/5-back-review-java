package com.example.backreviewjava.controller;

import com.example.backreviewjava.jpa.entity.MusicJpaEntity;
import com.example.backreviewjava.service.MusicJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/music-jpa-api")
public class MusicJpaController {

    private final MusicJpaService musicJpaService;
    @Autowired
    public MusicJpaController(MusicJpaService  musicJpaService) {
        this.musicJpaService = musicJpaService;
    }

    @GetMapping("all-music")
    public List<MusicJpaEntity> getAllMusic() {
        System.out.println("getAllMusic==========");
        return musicJpaService.getAllMusics();
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
