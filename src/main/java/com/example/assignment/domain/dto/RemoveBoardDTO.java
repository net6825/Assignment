package com.example.assignment.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RemoveBoardDTO {

    private Long id;
    private String password;
}
