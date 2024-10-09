package com.example.spring_demo.Dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UsersRequestDto {

  private Long userId;
  @NonNull
  @NotEmpty
  private String name;

  @NonNull
  @NotEmpty
  private String email;

  @NonNull
  @NotEmpty
  private String password;

}
