package com.example.spring_demo.auth;

import com.example.spring_demo.config.JwtServices;
import com.example.spring_demo.models.Users;
import com.example.spring_demo.respositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.NoSuchElementException;

@Component
public class UserUtil {

  private final JwtServices jwtServices;
  private final UsersRepository usersRepository;

  @Autowired
  public UserUtil(JwtServices jwtServices, UsersRepository usersRepository) {
    this.jwtServices = jwtServices;
    this.usersRepository = usersRepository;
  }

  public Users extractUserFromToken(String token) {
    if (token == null || token.isEmpty()) {
      throw new IllegalArgumentException("Token cannot be null or empty");
    }
    String username = jwtServices.extractUsername(token);
    return usersRepository.findByEmail(username).orElseThrow(() ->
      new NoSuchElementException("User not found with ID:" + username));
  }

}
