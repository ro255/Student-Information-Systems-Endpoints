package com.example.spring_demo.services;

import com.example.spring_demo.Dto.UsersRequestDto;
import com.example.spring_demo.responses.LoginResponse;
import com.example.spring_demo.responses.RegisterResponse;

public interface UserServices {

   public RegisterResponse<UsersRequestDto> register(UsersRequestDto users);

   public LoginResponse<UsersRequestDto> login(UsersRequestDto user);


}
