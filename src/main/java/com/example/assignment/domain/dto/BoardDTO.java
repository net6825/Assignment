package com.example.assignment.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class BoardDTO {

    private Long id;
    private String password;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private int count;
}
