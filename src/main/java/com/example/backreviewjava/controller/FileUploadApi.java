package com.example.backreviewjava.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


// 1
// 这个接口的作用是用来处理
// -- @RequestMapping 路径
// -- Swagger3
// -- 等注解用的，这样在真正的 controller class 中就干净很多了
@Tag(name = "File Upload API", description = "File Upload API")
@RequestMapping("/upload-api")
public interface FileUploadApi {


    // 1
    // handleFile
    @Operation(summary = "Get the template of file upload", description = "Get the template of file upload")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful", content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "400", description = "Failed", content = @Content)
    })
    @RequestMapping(value = "/getTemplate", method = RequestMethod.GET)
    public String handleFile();


    // 2
    // uploadFileByTemplate
    @Operation(summary = "Upload file by template", description = "Upload file by template")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful", content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "400", description = "Failed", content = @Content)
    })
    @RequestMapping(value = "/by-template", method = RequestMethod.POST)
    public String uploadFileByTemplate(
            @RequestPart("single") MultipartFile single,
            @RequestPart("multiple") MultipartFile[] multiple
    ) throws IOException;


    // 3
    // frontendUpload
    @Operation(summary = "Upload file by frontend", description = "Upload file by frontend")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful", content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "400", description = "Failed", content = @Content)
    })
    @RequestMapping(value = "/by-frontend", consumes = "multipart/form-data", method = RequestMethod.POST)
    @ResponseBody // 因为用的是 @controller，因为要返回html，而这里我们需要返回前后端分离后的数据，所以加上 @ResponseBody
    public String frontendUpload(
            // @RequestParam("file") MultipartFile avatars
            @RequestPart("file") MultipartFile avatars
    );



}
