package com.example.backreviewjava.service.impl;

import com.example.backreviewjava.service.FileDownloadJpaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Paths;
import java.sql.Blob;

@Service
@Slf4j
public class FileDownloadJpaServiceImpl implements FileDownloadJpaService {

    private static final String FILE_DIRECTORY = "src/main/java/com/example/backreviewjava/service/impl/";


    public Resource downloadFile() {

        // 1
        // File file = new File(filePath);
        // -- 使用 filePath 创建了一个 File 对象

        // 2
        // file.exists()

        // 3
        // FileSystemResource
        // -- FileSystemResource resource = new FileSystemResource(new File("path/to/file.txt"));
        // -- FileSystemResource resource = new FileSystemResource("path/to/file.txt");

        String filePath = FILE_DIRECTORY + "aa.txt";
        File file = new File(filePath);

        log.warn("当前工作目录: {}", Paths.get("").toAbsolutePath());
        log.warn("文件路径是: {}", filePath);


        if (!file.exists()) {
            throw new RuntimeException("File not found");
        }

        return new FileSystemResource(file);
    }
}
