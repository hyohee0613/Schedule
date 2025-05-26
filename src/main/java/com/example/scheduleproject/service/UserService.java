package com.example.scheduleproject.service;


import com.example.scheduleproject.dto.CreateUserRequestDto;
import com.example.scheduleproject.dto.CreateUserResponseDto;
import com.example.scheduleproject.entity.User;
import com.example.scheduleproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //유저 생성 CREATE
    public CreateUserResponseDto createUser(CreateUserRequestDto createUserRequestDto) {
        User user = new User();
        user.setUsername(createUserRequestDto.getUsername());
        user.setEmail(createUserRequestDto.getEmail());

        User usersaved = userRepository.save(user);

        return new CreateUserResponseDto(
                usersaved.getId(),
                usersaved.getUsername(),
                usersaved.getEmail(),
                usersaved.getCreatedAt(),
                usersaved.getUpdatedAt()
        );
    }



}
