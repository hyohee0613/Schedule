package com.example.scheduleproject.controller;

import com.example.scheduleproject.dto.CreateRequestDto;
import com.example.scheduleproject.dto.CreateResponseDto;
import com.example.scheduleproject.dto.GetScheduleResponseDto;
import com.example.scheduleproject.entity.Schedule;
import com.example.scheduleproject.repository.ScheduleRepository;
import com.example.scheduleproject.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // 전체일정 조회 GET
    @GetMapping
    public ResponseEntity<List<GetScheduleResponseDto>> getAllSchedules() {
        List<GetScheduleResponseDto> responseList = scheduleService.getAllSchedules();
        return ResponseEntity.ok(responseList);
    }

}
