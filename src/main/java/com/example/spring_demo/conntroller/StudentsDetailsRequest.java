package com.example.spring_demo.conntroller;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class StudentsDetailsRequest {

  private Integer RegistrationNumber;
  private String Programme;
  private String  MobileNo;
  private String Gender;
  private String Nationality;
  private LocalDate DateOfBirth;
  private String profile;
  private String Disability;
  private String YearOfStudy;
  private String FormIVIndex;


}
