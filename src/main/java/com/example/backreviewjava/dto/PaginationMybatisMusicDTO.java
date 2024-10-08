package com.example.backreviewjava.dto;


import com.example.backreviewjava.model.MusicMybatisModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Component // 万能
public class PaginationMybatisMusicDTO<T> {
    public List<T> musics;
    public Integer total;
    public Integer current;
    public Integer pageSize;
}
