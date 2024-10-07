package com.example.spring_demo.Dto;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ChangePasswordDto {

  private String oldPassword;
  private String newPassword;
  private String confirmPassword;

}
