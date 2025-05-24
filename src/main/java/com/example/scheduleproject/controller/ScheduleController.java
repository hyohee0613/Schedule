package com.example.scheduleproject.controller;

import com.example.scheduleproject.dto.CreateRequestDto;
import com.example.scheduleproject.dto.CreateResponseDto;
import com.example.scheduleproject.entity.Schedule;
import com.example.scheduleproject.repository.ScheduleRepository;
import com.example.scheduleproject.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    //속성
    private final ScheduleService scheduleService;


    //생성자
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    //기능

    // 일정 생성 CREATE
    @PostMapping("/create")
    public ResponseEntity<CreateResponseDto> createAPI(@RequestBody CreateRequestDto createRequestDto) {
        CreateResponseDto responseDto = scheduleService.createSchedule(createRequestDto);
        return ResponseEntity.status(201).body(responseDto);
    }

}
