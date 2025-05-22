package com.example.schedulepreject.controller;

import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    //속성


    //생성자



    //기능

    // 일정 생성 CREATE
    @PostMapping("/post")
    public String postSchedule() {
        //1. SQL문
        String sql = "INSERT INTO schedule VALUES(?,?,?) ";

        //2. 실행

        //3. 반환

    }

}
