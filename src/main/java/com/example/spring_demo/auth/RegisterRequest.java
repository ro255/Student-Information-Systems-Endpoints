package com.example.spring_demo.auth;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RegisterRequest {
  private String name;
  private String email;
  private String password;

}
