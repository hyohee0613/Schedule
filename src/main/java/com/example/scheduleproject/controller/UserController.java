package com.example.scheduleproject.controller;

import com.example.scheduleproject.dto.CreateUserRequestDto;
import com.example.scheduleproject.dto.CreateUserResponseDto;
import com.example.scheduleproject.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createuser")
    public ResponseEntity<CreateUserResponseDto> createUser(@RequestBody CreateUserRequestDto createUserRequestDto) {
        CreateUserResponseDto createUserResponseDto = userService.createUser(createUserRequestDto);
        return ResponseEntity.ok().body(createUserResponseDto);
    }
}
