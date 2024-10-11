package com.example.spring_demo.auth;

import com.example.spring_demo.responses.StudentDetailsResponse;
import com.example.spring_demo.responses.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AuthenticationResponse {
  private String token;
  private String message;
  private int statusCode;
  private UserResponse user;
  private StudentDetailsResponse studentDetails;


}
