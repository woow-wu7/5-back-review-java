//package com.example.backreviewjava.controller;
//
//import com.example.backreviewjava.model.Music;
//import com.example.backreviewjava.service.MusicService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@Slf4j
//@RequestMapping("/music-api")
//public class MusicController {
//
//    @Autowired
//    private MusicService musicService;
//
//    @GetMapping(value = "/all-musics")
//    public List<Music> getAllMusics() {
//        return musicService.getAllMusics();
//    }
//
////
////    @GetMapping("/{id}")
////    public User getUserById(@PathVariable Long id) {
////        return userService.getUserById(id);
////    }
////
////    @PostMapping
////    public User createUser(@RequestBody User user) {
////        return userService.createUser(user);
////    }
////
////    @PutMapping("/{id}")
////    public User updateUser(@PathVariable Long id, @RequestBody User user) {
////        user.setId(id);
////        return userService.updateUser(user);
////    }
////
////    @DeleteMapping("/{id}")
////    public void deleteUser(@PathVariable Long id) {
////        userService.deleteUser(id);
////    }
//}
