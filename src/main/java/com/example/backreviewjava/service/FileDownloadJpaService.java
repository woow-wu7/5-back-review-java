package com.example.backreviewjava.service;

import com.example.backreviewjava.dto.PaginationMybatisMusicDTO;
import com.example.backreviewjava.jpa.entity.MusicJpaEntity;
import org.springframework.core.io.Resource;

public interface FileDownloadJpaService {

    public Resource downloadFile();
}
