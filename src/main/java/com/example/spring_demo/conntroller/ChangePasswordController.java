package com.example.spring_demo.conntroller;

import com.example.spring_demo.services.ChangePasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;


@RestController
@RequestMapping("/api/v1/passUser")
@RequiredArgsConstructor

public class ChangePasswordController {

  private final ChangePasswordService changePasswordService;


  @PatchMapping
  public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequest request, Principal connectedUser) {

      changePasswordService.changePassword(request,connectedUser);
      return ResponseEntity.ok().build();

  }


}

