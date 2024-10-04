package com.example.spring_demo.services;

import com.example.spring_demo.auth.AuthenticationResponse;
import com.example.spring_demo.conntroller.AccommodationRequest;
import org.springframework.stereotype.Service;

@Service
public class AccommodationService {

  public AuthenticationResponse application(AccommodationRequest request) {

    return AuthenticationResponse.builder().build();
  }

}
