package com.example.spring_demo.responses;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ApiResponse <T> {
  private int statusCode;
  private String message;
  private T data;
  public ApiResponse(int statusCode, String message, T data) {
    this.statusCode = statusCode;
    this.message = message;
    this.data = data;
  }
}
