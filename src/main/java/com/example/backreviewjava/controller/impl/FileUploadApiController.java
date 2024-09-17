package com.example.backreviewjava.controller.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
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
// -- 3.
@Controller
@Slf4j
@RequestMapping("/upload-api")
public class FileUploadApiController {


    // 1
    @RequestMapping(value = "/getTemplate", method = RequestMethod.GET)
    public String handleFile(
    ) {
        // 1. 这里返回的是 resources/templates/fileUpload.html
        // 2. 需要安装 spring-boot-starter-thymeleaf 这个maven依赖
        // 3. -- 所以我们启动项目后，需要首先访问 http://localhost:9999/upload-api/getTemplate 来打开文件上传页面
        // 3. -- 然后提交表单，提交的路径是 'th:action="@{/upload-api/by-template}"' 对应 "/upload-api/by-template" 这个路径的方法 uploadFileByTemplate
        return "fileUpload";
    }


    // 2
    // 注意: "/upload-api/by-template" 需要和 fileUpload.html 中的 'th:action="@{/upload-api/by-template}"' 匹配
    @RequestMapping(value = "/by-template", method = RequestMethod.POST)
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

}
