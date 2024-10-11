package com.example.spring_demo.responses;

import com.example.spring_demo.models.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class UserResponse {
  private Long userId;
  private String name;
  private String email;
  private Role role;

}
