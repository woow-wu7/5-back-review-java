package com.example.backreviewjava.controller;

import com.example.backreviewjava.bean.MusicTestBean;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


// 1
// @RequestMapping 可以映射任何 HTTP 方法（GET、POST、PUT、DELETE 等）。
// @GetMapping 专门用于映射 HTTP GET 请求。

// 2
// parameters
// - path parameters
// - query parameters
// - request header parameters

// 3
/**
 * @Controller 可以返回html页面
 * @RestController 不能返回html页面，返回的内容就是return的内容
 * 1. @RestController = @Controller + @ResponseBody
 * 2. 如果一个controller，一些页面要返回html，一些又要返回return的内容，就需要用 @Controller注解controller返回html，然后在要返回的return的方法上加上@ResponseBody来返回return后面的内容
 */

// 4
// swagger3 annotation
// - @Tag(mame, description)
// - @Operation(summary, description)
// -
// - @ApiResponses(value)
// - @ApiResponse(responseCode, description) // @Content @Schema @ArraySchema
// -
// - @Parameter
// - @RequestBody 这个注解在 SpringBoot 中也存存，用来说明 post 请求的body 参数

// 5
// Spring boot
// - @RequestBody
// - @PathVariable



@Tag(name = "7-back-review-java-api", description = "Operations for public access")
@RestController
@Slf4j
@RequestMapping("/music-api")
public class MusicTestController {

    @Autowired
    public MusicTestBean musicBean;

    private List<MusicTestBean> musics = new ArrayList<>();

    // 1
    // @GetMapping("/name")
    // @RequestMapping(value = "/music", method = RequestMethod.GET, params = "name,age")


    // [1.1]
    // GET one music
    @Operation(summary = "Get one music", description = "Returns a music")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = @Content(schema = @Schema(implementation = MusicTestBean.class))),
            @ApiResponse(responseCode = "404", description = "Failed",
                    content = @Content)
    })
    @GetMapping("/music")
    public MusicTestBean getMusic(@RequestParam(required = false) String name, @RequestParam(defaultValue = "周杰伦")   @Parameter(description = "default singer is Jiezhou") String singer) {
        return musicBean.builder()
                .name(name)
                .singer("wu99")
                .album(singer)
                .time(new Date())
                .build();
    }


    // [1.2]
    // GET all musics
    @Operation(summary = "Get all musics", description = "Returns all musics")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful", content = @Content(array = @ArraySchema(schema = @Schema(implementation = MusicTestBean.class)))),
            @ApiResponse(responseCode = "404", description = "Failed", content = @Content)
    })
    @GetMapping("/all-musics")
    public ResponseEntity<List<MusicTestBean>> getAllMusic() {

        MusicTestBean musicBean = new MusicTestBean(1, "七里香", "八度空间", "周杰伦", new Date());
        MusicTestBean musicBean2 = new MusicTestBean(2, "晴天", "无与伦比", "周杰伦", new Date());
        musics.add(musicBean);
        musics.add(musicBean2);

        return ResponseEntity.ok(musics);
    }



    // [2]
    // POST a music
    @Operation(summary = "Add a music", description = "Add a music")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Music created successfully", content = @Content(schema = @Schema(implementation = MusicTestBean.class))),
            @ApiResponse(responseCode = "400", description = "Music created unsuccessfully", content = @Content)
    })
    @PostMapping(("/music"))
    public ResponseEntity<MusicTestBean> addMusic(@RequestBody MusicTestBean music) {
        log.info("addMusic: {}", music);
        musics.add(music);
        return ResponseEntity.status(201).body(music);
    }


    // [3]
    // DELETE a music
    @Operation(summary = "Delete a music", description = "Delete a music")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Music deleted successfully", content = @Content),
            @ApiResponse(responseCode = "404", description = "Music deleted unsuccessfully", content = @Content)
    })
    @DeleteMapping("/music/{musicId}")
    public ResponseEntity<MusicTestBean> deleteMusic(@PathVariable @Parameter(description = "musicId")  Integer musicId) {
        MusicTestBean musicBean = new MusicTestBean(1, "七里香", "八度空间", "周杰伦", new Date());

        System.out.println(musicId);
        log.info("Music deleted successfully" + musicId);

        return  ResponseEntity.status(201).body(musicBean);
    }
}