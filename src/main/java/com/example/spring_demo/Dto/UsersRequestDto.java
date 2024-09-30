package com.example.spring_demo.Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter

public class UsersRequestDto {
  private String name;
  private String email;
  private String password;


}
