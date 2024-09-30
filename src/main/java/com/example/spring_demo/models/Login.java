package com.example.spring_demo.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Login {

  @Id
  private Long id;

  @Column(unique = true,nullable = false)
  private String email;

  @Column(unique = true, nullable = false)
  private String password;
}
