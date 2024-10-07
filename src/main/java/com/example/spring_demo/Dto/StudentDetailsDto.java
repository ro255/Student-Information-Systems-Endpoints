package com.example.spring_demo.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class StudentDetailsDto {

//  private String RegistrationNumber;
//  private String Programme;
//  private String  MobileNo;
//  private String Gender;
//  private String Nationality;
//  private LocalDate DateOfBirth;
//  private String profile;
//  private String disability;
//  private String YearOfStudy;
//  private String FormIVIndex;
@JsonProperty("RegistrationNumber")
private String registrationNumber;

  @JsonProperty("Programme")
  private String programme;

  @JsonProperty("MobileNo")
  private String mobileNo;

  @JsonProperty("Gender")
  private String gender;

  @JsonProperty("Nationality")
  private String nationality;

  @JsonProperty("DateOfBirth")
  private String dateOfBirth;

  @JsonProperty("profile")
  private String profile;

  @JsonProperty("disability")
  private String disability;

  @JsonProperty("YearOfStudy")
  private String yearOfStudy;

  @JsonProperty("FormIVIndex")
  private String formIVIndex;
}
