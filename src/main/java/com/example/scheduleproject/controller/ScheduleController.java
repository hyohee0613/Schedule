package com.example.scheduleproject.controller;

import com.example.scheduleproject.dto.CreateRequestDto;
import com.example.scheduleproject.dto.CreateResponseDto;
import com.example.scheduleproject.entity.Schedule;
import com.example.scheduleproject.repository.ScheduleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    //속성
    private final ScheduleRepository scheduleRepository;


    //생성자
    public ScheduleController(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    //기능

    // 일정 생성 CREATE
    @PostMapping("/create")
    public ResponseEntity<CreateResponseDto> createAPI (@RequestBody CreateRequestDto createrequestDto) {
        //반환 타입은 ResponseEntity, 즉 HTTP 응답 전체를 담을 수 있는 객체
        //@RequestBody: 클라이언트가 보낸 JSON 데이터를 CreateRequestDto 객체로 바꿔줌

        // 1. DTO → Entity 변환
        Schedule schedule = new Schedule();   //빈 Schedule 엔티티를 하나 생성함
        schedule.setName(createrequestDto.getName());   //요청에서 받은 name 값을 엔티티에 넣음
        schedule.setTitle(createrequestDto.getTitle());
        schedule.setPassword(createrequestDto.getPassword());

        // 2. DB에 저장
        //생성한 Schedule 엔티티를 DB에 저장함
        //저장되면서 id, updatedAt 같은 필드도 자동으로 채워지고 이 객체가 saved에 담김
        Schedule saved = scheduleRepository.save(schedule);

        // 3. Entity → 응답 DTO로 변환
        CreateResponseDto responseDto = new CreateResponseDto(      //저장된 Schedule 엔티티를 가지고 응답용 DTO를 생성함
                //클라이언트가 필요로 하는 필드만 골라서 포함
                saved.getId(),
                saved.getName(),
                saved.getTitle(),
                saved.getUpdatedAt()
        );

        // 4. 응답 반환
        //HTTP 상태 코드 201(Created)와 함께 responseDto를 응답 본문으로 담아 클라이언트에게 반환
        return ResponseEntity.status(201).body(responseDto);

    }

}
