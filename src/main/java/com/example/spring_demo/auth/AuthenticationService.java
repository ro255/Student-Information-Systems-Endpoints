package com.example.spring_demo.auth;

import com.example.spring_demo.models.Role;
import com.example.spring_demo.respositories.UsersRepository;
import com.example.spring_demo.config.JwtServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import static com.example.spring_demo.models.Users.*;

@Service
public class AuthenticationService {

  @Autowired
  private final UsersRepository usersRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtServices jwtServices;

  @Autowired
  public AuthenticationService(UsersRepository usersRepository, PasswordEncoder passwordEncoder, JwtServices jwtServices, AuthenticationManager authenticationManager) {
    this.usersRepository = usersRepository;
    this.passwordEncoder = passwordEncoder;
    this.jwtServices = jwtServices;
    this.authenticationManager = authenticationManager;
  }

  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest request) {

    var user= builder()
      .name(request.getName())
      .email(request.getEmail())
      .password(passwordEncoder.encode(request.getPassword()))
      .role(Role.USER)
      .build();

    usersRepository.save(user);
    var jwtToken=jwtServices.generateToken(user);
    return AuthenticationResponse.builder()
      .token(jwtToken)
      .build();
  }


  public AuthenticationResponse login(LoginRequest request) {
      authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
          request.getEmail(),
          request.getPassword()
        )
      );
      var user=usersRepository.findByEmail(request.getEmail()).orElseThrow();
    var jwtToken=jwtServices.generateToken(user);
    return AuthenticationResponse.builder()
      .token(jwtToken)
      .build();
  }

  public AuthenticationResponse updateUser(RegisterRequest request) {
    var user= builder()
      .name(request.getName())
      .email(request.getEmail())
      .password(passwordEncoder.encode(request.getPassword()))
      .role(Role.USER)
      .build();

    usersRepository.save(user);
    var jwtToken=jwtServices.generateToken(user);
    return AuthenticationResponse.builder()
      .token(jwtToken)
      .build();

  }

}
