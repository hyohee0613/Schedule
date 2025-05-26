package com.example.scheduleproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CreateUserResponseDto {

    private Long id;
    private String email;
    private String username;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

}
