package com.example.assignment.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateBoardDTO {
    private Long id;
    private String title;
    private String password;
    private String content;
}
