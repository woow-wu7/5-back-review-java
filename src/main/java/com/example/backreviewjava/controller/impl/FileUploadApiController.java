package com.example.backreviewjava.controller.impl;

import com.example.backreviewjava.controller.FileUploadApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

// 1
// Pay attention
// -- make sure to use '@Controller' to instead of the '@RestController' when implementing upload function.
// -- @Controller

// 2
// Detailed Process
// -- 1. FileUploadApiController
// ------ We should return the 'fileUpload' html template through the handleFile function firstly.
// ------ ( http://localhost:9999/upload-api/getTemplate )
// -- 2. resources/templates/fileUpload.html
// ------ The 'th:action="@{/upload-api/by-template}"' attribute in form tag should math the 'uploadFileByTemplate' function.

// 3
/**
 * @Controller 可以返回html页面
 * @RestController 不能返回html页面，返回的内容就是return的内容
 * 1. @RestController = @Controller + @ResponseBody
 * 2. 如果一个controller，一些页面要返回html，一些又要返回return的内容，就需要用 @Controller注解controller返回html，然后在要返回的return的方法上加上@ResponseBody来返回return后面的内容
 */

// 4
// 注意：前端上传组件的name="aaa"，是和java中的 @RequestPart("aaa") 对应的
// 注意: "/upload-api/by-template" 需要和 fileUpload.html 中的 'th:action="@{/upload-api/by-template}"' 匹配

@Controller // Pay attention.
@Slf4j
public class FileUploadApiController implements FileUploadApi {

    // (1)
    public String handleFile() {
        // 1. 这里返回的是 resources/templates/fileUpload.html
        // 2. 需要安装 spring-boot-starter-thymeleaf 这个maven依赖
        // 3. -- 所以我们启动项目后，需要首先访问 http://localhost:9999/upload-api/getTemplate 来打开文件上传页面
        // 3. -- 然后提交表单，提交的路径是 'th:action="@{/upload-api/by-template}"' 对应 "/upload-api/by-template" 这个路径的方法 uploadFileByTemplate
        // 注意: return "fileUpload" 需要和 resources/templates/fileUpload.html 的html的文件名一样
        return "fileUpload"; // 对应 "fileUpload.htlm"
    }


    //（2）
    // 注意: "/upload-api/by-template" 需要和 fileUpload.html 中的 'th:action="@{/upload-api/by-template}"' 匹配
    public String uploadFileByTemplate(
            @RequestPart("single") MultipartFile single,
            @RequestPart("multiple") MultipartFile[] multiple
    ) throws IOException {

        log.warn("上传的单文件{}", single);
        log.warn("上传的多文件{}", multiple);

        if (!single.isEmpty()) {
            // originalFilename: 获取原始文件名
            // transferTo: 保存到 ( Users/xiawu/work/personal... ) 文件夹
            String originalFilename = single.getOriginalFilename();
            log.warn("上传单文件文件名是:{}", originalFilename);
            single.transferTo(new File("/Users/xiawu/work/personal/back-end/back-review-java/src/main/resources/templates/files" + originalFilename));
        }

        if (multiple.length > 0) {
            for (MultipartFile file : multiple) { // for循环
                if (!file.isEmpty()) {
                    String originalFilename = file.getOriginalFilename(); // 原始文件名
                    long size = file.getSize()/1024; // 文件大小，默认但是为字节，1MB = 1024KB = 1024 * 1024 byte
                    log.info("文件名{}. 大小{}KB", originalFilename, size);
                    file.transferTo(new File("/Users/xiawu/work/personal/back-end/back-review-java/src/main/resources/templates/files" + originalFilename));
                }
            }
        }

        return "fileUpload"; // 返回 fileUpload.html
    }


    // (3)
    // 前后端分离的接口
    // 注意点
    // 1. consumes 一定要设置成 "multipart/form-data" 因为前端 antd 中的 Upload 组件是用的 form-data 方式在上传
    // 2. 前端上传时 Upload 组件一定要设置 name 属性，因为 name 的值是和这里的 @RequestPart("前端name属性的值") 一一对应
    // 3. consume 是消费的意思
    @ResponseBody // 因为用的是 @controler，因为要返回html，而这里我们需要返回前后端分离后的数据，所以加上 @ResponseBody
    public String frontendUpload(
            // @RequestParam("file") MultipartFile avatars
            @RequestPart("file") MultipartFile avatars
    ) {
        System.out.println(avatars);
        return "上传成功";
    }

}
