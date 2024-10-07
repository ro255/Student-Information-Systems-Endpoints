package com.example.spring_demo.services;

import com.example.spring_demo.Dto.ChangePasswordDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@Transactional

public interface ChangePasswordService {
  void changePassword(ChangePasswordDto changePasswordDto, Principal connectedUser);

}
