package com.example.spring_demo.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class NhifApplicationDto {

  @JsonProperty("CardNumber")
  private String CardNumber;

  @JsonProperty("Category")
  private String Category;

  @JsonProperty("NHIF_SubmissionResponse")
  private String NHIF_SubmissionResponse;

  @JsonProperty("NHIF_SubmissionTime")
  private String NHIF_SubmissionTime;

  @JsonProperty("Control_Number")
  private String Control_Number;

  @JsonProperty("Identification_Number")
  private String Identification_Number;

  @JsonProperty("Amount")
  private String Amount;

  @JsonProperty("status")
  private String status;

}
