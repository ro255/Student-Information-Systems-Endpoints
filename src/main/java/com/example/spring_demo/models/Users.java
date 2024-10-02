package com.example.spring_demo.models;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Users implements UserDetails {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "userId")
  private Long userId;

  @Column()
  private String name;

  @Column(unique = true)
  private String email;

  @Column(unique = true)
  private String password;


  @Enumerated(EnumType.STRING)
  private Role role;

  @OneToOne
  @JoinColumn(name = "cardId")
  private NhifApplication nhifApplication;


  /**
   * @return
   */
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }

  /**
   * @return
   */

  @Override
  public String getPassword() {
    return password;
  }

  /**
   * @return
   */
  @Override
  public String getUsername() {
    return email;
  }

  /**
   * @return
   */
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  /**
   * @return
   */
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  /**
   * @return
   */
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  /**
   * @return
   */
  @Override
  public boolean isEnabled() {
    return true;
  }


}
