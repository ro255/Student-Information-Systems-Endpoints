package com.example.spring_demo.Dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.NonNull;

@Builder
public class LoginRequestDto {
  @NonNull
  @NotEmpty
  private String email;
  @NonNull
  @NotEmpty
  private String password;
}
