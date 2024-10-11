package com.example.spring_demo.responses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StudentDetailsResponse {
  private String registrationNumber;
  private String programme;
  private String mobileNo;
  private String gender;
  private String nationality;
  private String dateOfBirth;
  private String profile;
  private String disability;
  private String yearOfStudy;
  private String formIVIndex;

  // Builder, getters, setters
}
