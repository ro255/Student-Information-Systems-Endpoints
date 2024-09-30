package com.example.spring_demo.responses;

import com.example.spring_demo.Dto.UsersRequestDto;
import lombok.Data;

@Data
public class RegisterResponse<T> {
  private String message;
  private  String code;
  private T data;

  public RegisterResponse(String message, String code, T data) {
    this.message = message;
    this.code = code;
    this.data = data;
  }

  public RegisterResponse(String message, String code) {
    this.message = message;
    this.code = code;
  }

  public RegisterResponse(String loginSuccessfully, UsersRequestDto user) {
    this.message=loginSuccessfully;

  }

}
