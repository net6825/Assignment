package com.example.assignment.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class BoardFormDTO {

    private String title;
    private String content;
    private String password;
}