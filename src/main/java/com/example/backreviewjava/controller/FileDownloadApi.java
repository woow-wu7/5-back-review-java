package com.example.backreviewjava.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.core.io.Resource;

@Tag(name = "File Download API", description = "File Download API")
@RequestMapping("/download-api")
public interface FileDownloadApi {

    @RequestMapping(value = "/download-file", method = RequestMethod.GET)
    public ResponseEntity<Resource> downloadFile();
}
