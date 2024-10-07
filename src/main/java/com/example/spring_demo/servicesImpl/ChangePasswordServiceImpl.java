package com.example.spring_demo.servicesImpl;

import com.example.spring_demo.Dto.ChangePasswordDto;
import com.example.spring_demo.models.Users;
import com.example.spring_demo.respositories.UsersRepository;
import com.example.spring_demo.services.ChangePasswordService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class ChangePasswordServiceImpl implements ChangePasswordService {

  private final PasswordEncoder passwordEncoder;
  private final UsersRepository usersRepository;

  public ChangePasswordServiceImpl(PasswordEncoder passwordEncoder, UsersRepository usersRepository) {
    this.passwordEncoder = passwordEncoder;
    this.usersRepository = usersRepository;
  }

  public void changePassword(ChangePasswordDto request, Principal connectedUser) {
    var user= (Users)((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

    if(!passwordEncoder.matches(request.getOldPassword(), user.getPassword())){
      throw new BadCredentialsException("Old password does not match");
    }

    if(!request.getNewPassword().equals(request.getConfirmPassword())) {
      throw new BadCredentialsException("Passwords does not match");
    }

    user.setPassword(passwordEncoder.encode(request.getNewPassword()));

    usersRepository.save(user);

  }
}
