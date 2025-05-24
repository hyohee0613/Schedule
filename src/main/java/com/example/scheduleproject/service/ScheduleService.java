package com.example.scheduleproject.service;

import com.example.scheduleproject.dto.CreateRequestDto;
import com.example.scheduleproject.dto.CreateResponseDto;
import com.example.scheduleproject.entity.Schedule;
import com.example.scheduleproject.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public CreateResponseDto createSchedule(CreateRequestDto createRequestDto) {
        // 1. DTO → Entity
        Schedule schedule = new Schedule();   //빈 Schedule 엔티티를 하나 생성함
        schedule.setName(createRequestDto.getName());   //요청에서 받은 name 값을 엔티티에 넣음
        schedule.setTitle(createRequestDto.getTitle());
        schedule.setPassword(createRequestDto.getPassword());

        // 2. DB 저장
        //생성한 Schedule 엔티티를 DB에 저장함
        //저장되면서 id, updatedAt 같은 필드도 자동으로 채워지고 이 객체가 saved에 담김
        Schedule saved = scheduleRepository.save(schedule);

        // 3. Entity → 응답 DTO로 변환
        return new CreateResponseDto (
                //저장된 Schedule 엔티티를 가지고 응답용 DTO를 생성함
                //클라이언트가 필요로 하는 필드만 골라서 포함
                saved.getId(),
                saved.getName(),
                saved.getTitle(),
                saved.getUpdatedAt()
        );

    }
}
