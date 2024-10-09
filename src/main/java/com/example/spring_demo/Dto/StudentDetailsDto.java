package com.example.spring_demo.Dto;

import com.example.spring_demo.validation.ValidateGender;
import com.example.spring_demo.validation.ValidateProgramme;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class StudentDetailsDto {

  @NonNull
  @NotEmpty
  @JsonProperty("RegistrationNumber")
  private String registrationNumber;

  @ValidateProgramme
  @JsonProperty("Programme")
  private String programme;

  @NonNull
  @NotEmpty
  @JsonProperty("MobileNo")
  private String mobileNo;

  @ValidateGender
  @JsonProperty("Gender")
  private String gender;

  @NonNull
  @NotEmpty
  @JsonProperty("Nationality")
  private String nationality;

  @NonNull
  @NotEmpty
  @JsonProperty("DateOfBirth")
  private String dateOfBirth;

  @NonNull
  @NotEmpty
  @JsonProperty("profile")
  private String profile;

  @NonNull
  @NotEmpty
  @JsonProperty("disability")
  private String disability;

  @NonNull
  @NotEmpty
  @JsonProperty("YearOfStudy")
  private String yearOfStudy;

  @NonNull
  @NotEmpty
  @JsonProperty("FormIVIndex")
  private String formIVIndex;
}
