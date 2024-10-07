package com.example.spring_demo.conntroller;

import com.example.spring_demo.Dto.ChangePasswordDto;
import com.example.spring_demo.services.ChangePasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/passUser")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class ChangePasswordController {

  private final ChangePasswordService changePasswordService;

  @PatchMapping
  public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDto changePasswordDto, Principal connectedUser) {

      changePasswordService.changePassword(changePasswordDto,connectedUser);
      return ResponseEntity.ok().build();

  }


}

