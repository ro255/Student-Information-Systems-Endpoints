package com.example.spring_demo.services;

import com.example.spring_demo.Dto.UsersRequestDto;
import com.example.spring_demo.responses.LoginResponse;
import com.example.spring_demo.responses.RegisterResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public interface UserServices {

   RegisterResponse<UsersRequestDto> register(UsersRequestDto users);

   LoginResponse<UsersRequestDto> login(UsersRequestDto user);


}
