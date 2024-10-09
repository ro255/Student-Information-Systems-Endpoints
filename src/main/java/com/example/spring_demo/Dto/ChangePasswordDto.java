package com.example.spring_demo.Dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ChangePasswordDto {

  @NonNull
  @NotEmpty
  private String oldPassword;
  @NonNull
  @NotEmpty
  private String newPassword;
  @NonNull
  @NotEmpty
  private String confirmPassword;

}
