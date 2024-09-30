package com.example.spring_demo.services;

import com.example.spring_demo.models.Role;
import com.example.spring_demo.models.Users;
import com.example.spring_demo.respositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUsersDetailsService implements UserDetailsService {

  @Autowired
  private UsersRepository usersRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Optional<Users> optionalUser = usersRepository.findByEmail(email);

    if (optionalUser.isEmpty()) {
      throw new UsernameNotFoundException("User not found");
    }

    Users user = optionalUser.get();


    return new org.springframework.security.core.userdetails.User(
      user.getEmail(),
      user.getPassword(),
      getAuthorities(user.getRole())
    );
  }


  private List<GrantedAuthority> getAuthorities(Role role) {
    List<GrantedAuthority> authorities = new ArrayList<>();
    if (role != null) {
      authorities.add(new SimpleGrantedAuthority(role.name()));
    }
    return authorities;
  }
}
