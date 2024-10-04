package com.example.spring_demo.services;

import com.example.spring_demo.auth.AuthenticationResponse;
import com.example.spring_demo.conntroller.StudentsDetailsRequest;
import org.springframework.stereotype.Service;

@Service

public class StudentDetailsService {

  public AuthenticationResponse studentDetails(StudentsDetailsRequest request) {
    return AuthenticationResponse.builder().build();

  }

}
