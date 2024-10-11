package com.example.spring_demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@SQLDelete(sql = "UPDATE users SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
//@Where(clause = "deleted = false")

public class Users implements UserDetails {

  @Id
  @Column(name = "user_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;

  @Column(nullable = false)
  @NotBlank(message = "Please provide a name")
  private String name;

  @Column(unique = true, nullable = false)
  @Email(message = "Provide a valid email address or email already exists")
  private String email;

  @Column(nullable = false)
  @Size(min = 8, message = "Password must be at least 8 characters long")
  private String password;

  @Enumerated(EnumType.STRING)
  private Role role;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @OneToOne(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
  private StudentsDetails studentsDetails;

  }
