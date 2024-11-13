package com.example.backreviewjava.controller;

import com.example.backreviewjava.dto.PaginationMybatisMusicDTO;
import com.example.backreviewjava.jpa.entity.MusicJpaEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.util.List;


// 1
// 这个接口的作用是用来处理
// -- @RequestMapping 路径
// -- Swagger3
// -- 等注解用的，这样在真正的 controller class 中就干净很多了
@Tag(name = "Test jpa and swagger3", description = "Test jpa and swagger3")
@RequestMapping("/music-jpa-api")
public interface MusicJpaApi {

    // 1
    // getAllMusics
    @Operation(summary = "Get all musics", description = "Returns a list of all musics")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful", content = @Content(array = @ArraySchema(schema = @Schema(implementation = MusicJpaEntity.class)))),
            @ApiResponse(responseCode = "400", description = "Failed", content = @Content)
    })
    @RequestMapping(value = "/all-music", method = RequestMethod.GET)
    public PaginationMybatisMusicDTO<MusicJpaEntity> getAllMusics();


    // 1
    // getMusicById
    @Operation(summary = "Get one music by id", description = "Returns a music")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful", content = @Content(schema = @Schema(implementation = MusicJpaEntity.class))),
            @ApiResponse(responseCode = "400", description = "Failed", content = @Content)
    })
    @RequestMapping(value = "/music/{id}", method = RequestMethod.GET)
    public MusicJpaEntity getMusicById(@PathVariable Integer id);


    // 1
    // 【 getAllMusicsThroughEntityManger 】!!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!!
    // 使用 EntityManager 来手动创建和执行查询的场景
    // - 简化开发：Spring Data JPA 提供了许多内置的方法，如 findAll()、findById()、save() 等，可以大大简化数据访问层的开发。
    // - 自动生成查询：你可以通过方法名约定来自动生成查询，例如 findByName(String name) 会自动生成一个根据 name 字段查询的查询语句。
    // - 适用于简单查询：当你需要处理简单的 CRUD 操作时，这种方式非常方便。
    // ---- 问题: JPA 有几种查询方式
    // ---- 1. JpaRepository 接口: 自动，简单
    // -----2. EntityManager: 手动创建和执行查询，更灵活，但需要更多的代码
    @Operation(summary = "Get all musics through EntityManager", description = "Returns a list of all musics")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful", content = @Content(array = @ArraySchema(schema = @Schema(implementation = MusicJpaEntity.class)))),
            @ApiResponse(responseCode = "400", description = "Failed", content = @Content)
    })
    @RequestMapping(value = "/musicsThroughEntityManger", method = RequestMethod.GET)
    public List<MusicJpaEntity> getAllMusicsThroughEntityManger();

    // 1
    // 【 getMusicsByIds 】!!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!!
    // => findByIdIn => Select * from AAA where id in (1,2,3)
    @Operation(summary = "Get one musics by ids.", description = "Returns a music list.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful", content = @Content(array = @ArraySchema(schema = @Schema(implementation = MusicJpaEntity.class)))),
            @ApiResponse(responseCode = "400", description = "Failed", content = @Content)
    })
    @RequestMapping(value = "/musics", method = RequestMethod.GET)
    public PaginationMybatisMusicDTO<MusicJpaEntity> getMusicsByIds(@RequestParam String ids);


    // 1
    // 外键
    //【 getMusicBySinger 】!!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!!
    // 跨表查询 singer_id => table singer id
    // music(singer_id) => singer(id)
    @GetMapping("/music/getAllMusicByForeignKey")
    public PaginationMybatisMusicDTO<MusicJpaEntity> getAllMusicByForeignKey();

    // 1
    //【 searchMusic 】 !!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!! !!!!!!!
    // -- fuzzy query 模糊查询
    // -- => keyword
    @Operation(summary = "Search a music", description = "Search a music")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful", content = @Content(array = @ArraySchema(schema = @Schema(implementation = MusicJpaEntity.class)))),
            @ApiResponse(responseCode = "400", description = "Failed", content = @Content)
    })
    @RequestMapping(value = "/music", method = RequestMethod.GET)
    public List<MusicJpaEntity> searchMusic(@RequestParam String keyword);

    // 2
    // addMusic
    @Operation(summary = "Add a music", description = "Add a music")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Music created successfully", content = @Content(schema = @Schema(implementation = MusicJpaEntity.class))),
            @ApiResponse(responseCode = "400", description = "Music created unsuccessfully", content = @Content)
    })
    @RequestMapping(value = "/music", method = RequestMethod.POST)
    public void addMusic(@RequestBody @Parameter(description = "music", required = true, schema = @Schema(implementation = MusicJpaEntity.class)) MusicJpaEntity music);

    // 3
    // edit
    @Operation(summary = "Edit a music", description = "Edit a music")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Music edited successfully", content = @Content(schema = @Schema(implementation = MusicJpaEntity.class))),
            @ApiResponse(responseCode = "400", description = "Music edited unsuccessfully", content = @Content)
    })
    @RequestMapping(value = "/music", method = RequestMethod.PUT)
    public  void editMusic(@RequestBody MusicJpaEntity music);

    // 4
    // delete
    @Operation(summary = "Delete a music", description = "Delete a music")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Music deleted successfully", content = @Content),
            @ApiResponse(responseCode = "404", description = "Music deleted unsuccessfully", content = @Content)
    })
    @RequestMapping(value = "/music/{id}", method = RequestMethod.DELETE)
    public void deleteMusic(@PathVariable Integer id);
}
