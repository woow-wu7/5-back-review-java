package com.example.backreviewjava.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class MusicCustomSampleJpaEntity {
    private String name;
    private String singer;
}
