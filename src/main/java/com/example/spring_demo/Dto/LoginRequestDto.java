package com.example.spring_demo.Dto;

import lombok.Builder;

@Builder
public class LoginRequestDto {
  private String email;
  private String password;
}
