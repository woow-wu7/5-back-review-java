package com.example.backreviewjava.controller;

import com.example.backreviewjava.jpa.entity.MusicJpaEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<MusicJpaEntity> getAllMusics();


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
    // searchMusic
    // -- fuzzy query
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
