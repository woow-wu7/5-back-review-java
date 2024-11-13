package com.example.backreviewjava.service.impl;

import com.example.backreviewjava.service.FileDownloadJpaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStreamWriter;
import java.nio.file.Paths;
import java.sql.Blob;
import java.util.List;

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



        // start
        // ------- ------- ------- ------- ------- ------- ------- ------- -------
        // ------- ------- ------- ------- ------- ------- ------- ------- -------


        // List<ApplicationSearchVo> data = vo.getData();

        // 1
        // 1.1
        // ByteArrayOutputStream
        // -- 它是一个字节输出流，用于将数据写入一个内部的字节数组缓冲区
        // 1.2
        // ByteArrayOutputStream()
        // -- 是 ByteArrayOutputStream 类的一个无参构造函数。
        // -- 它创建一个新的 ByteArrayOutputStream 对象，并初始化一个内部的字节数组缓冲区

        // 2
        // 2.1
        // OutputStreamWriter
        // -- 用于将 （ 字符数据 ）写入 （ 字节输出流 ）
        // -- OutputStreamWriter 可以将字符编码为字节，并写入底层的字节输出流
        // 2.2
        // -- OutputStreamWriter(OutputStream out)

        // 将对象数组转换为 CSV 格式
        // ByteArrayOutputStream out = new ByteArrayOutputStream();
        // BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

        // 写入表头
        // writer.write("caseId,consigneeName,referenceNo,requestedRouting,shipperName,status,submissionDate,type\n");

        // 写入数据行
//        for(ApplicationSearchVo item : data) {
//            writer.write(
//                    item.getCaseId() + "," +
//                            item.getConsigneeName() + "," +
//                            item.getReferenceNo() + "," +
//                            item.getRequestedRouting() + "," + // 注意这里添加了 requestedRouting 字段
//                            item.getShipperName() + "," +
//                            item.getStatus() + "," +
//                            item.getSubmissionDate() + "," +
//                            item.getType() + "\n");
//        }

        // writer.flush();
        // writer.close();

        // 创建 ByteArrayResource
        // ByteArrayResource resource = new ByteArrayResource(out.toByteArray());

        // HttpHeaders headers = new HttpHeaders();
        // headers.setContentDispositionFormData("attachment", "application_records.csv");
        // headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        // return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);

        // end
        // ------- ------- ------- ------- ------- ------- ------- ------- -------
        // ------- ------- ------- ------- ------- ------- ------- ------- -------

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
