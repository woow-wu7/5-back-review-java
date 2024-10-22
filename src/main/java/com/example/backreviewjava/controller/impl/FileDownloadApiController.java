package com.example.backreviewjava.controller.impl;


import com.example.backreviewjava.controller.FileDownloadApi;
import com.example.backreviewjava.service.FileDownloadJpaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller // Pay attention.
@Slf4j
public class FileDownloadApiController implements FileDownloadApi {


    private final FileDownloadJpaService fileDownloadJpaService;

    // Inject multiple classes.
    @Autowired
    public FileDownloadApiController(FileDownloadJpaService fileDownloadJpaService) {
        this.fileDownloadJpaService = fileDownloadJpaService;
    }

    // (1)
    public ResponseEntity<Resource> downloadFile() {

        // 1
        // Content-Disposition
        // -- dispose 处理 处置 v
        // -- disposition 处理 处置 n

        // 2
        // Content-Type: application/octet-stream
        // -- 指示浏览器将响应内容作为文件下载

        Resource resource = fileDownloadJpaService.downloadFile();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", "download.csv");
        headers.setContentType(MediaType.TEXT_PLAIN);

        // headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // headers.add(HttpHeaders.CONTENT_TYPE, "text/plain");

        return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
    }
}
