package com.example.spring_demo.Dto;

import lombok.*;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UsersRequestDto {

  private Long userId;
  private String name;
  private String email;
  private String password;


}
