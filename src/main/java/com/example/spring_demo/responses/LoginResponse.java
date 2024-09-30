package com.example.spring_demo.responses;

import lombok.Data;

@Data

public class LoginResponse <T> {
  private String message;
  private String code;
  private T data;

  public LoginResponse(String message, T data) {
    this.message = message;
    this.data = data;
    this.code = code;
  }

  public LoginResponse(String code, String message) {
    this.message = message;
    this.code = code;
  }

}
