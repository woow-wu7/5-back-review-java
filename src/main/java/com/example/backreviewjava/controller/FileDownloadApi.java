package com.example.backreviewjava.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.core.io.Resource;

@Tag(name = "File Download API", description = "File Download API")
@RequestMapping("/download-api")
public interface FileDownloadApi {

    // 1
    // produces
    // 指定该方法可以生成的 MIME 类型
    // -- text/csv：表示响应的内容是 CSV 格式的文本
    // -- application/octet-stream：表示响应的内容是二进制流，通常用于文件下载
    // -- application/vnd.error+json：表示响应的内容是 JSON 格式的错误信息

    // 2
    // MIME 类型（Multipurpose Internet Mail Extensions type）是一种标准，用于表示文档、文件或字节流的性质和格式
    // -- MIME 类型通常由两部分组成：类型（type）和子类型（subtype），中间用斜杠 / 分隔
    // -- text/plain：表示纯文本文件
    // -- image/jpeg：表示 JPEG 格式的图片
    // -- application/json：表示 JSON 格式的数据

    // 3
    // Resource
    // Resource 是 Spring 中的一个接口，表示一个资源（如文件、URL 资源等）
    // -- 它提供了一些方法来访问和操作资源，例如读取资源内容、获取资源路径等
    @RequestMapping(
            value = "/download-file",
            produces = {"text/csv", "application/octet-stream", "application/vnd.error+json"}, // MIME
            method = RequestMethod.GET
    )
    public ResponseEntity<Resource> downloadFile();
}
