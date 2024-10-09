package com.example.spring_demo.Dto;

import com.example.spring_demo.validation.ValidateStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class NhifApplicationDto {
  @NonNull
  @NotEmpty
  @JsonProperty("CardNumber")
  private String CardNumber;

  @NonNull
  @NotEmpty
  @JsonProperty("Category")
  private String Category;

  @NonNull
  @NotEmpty
  @JsonProperty("NHIF_SubmissionResponse")
  private String NHIF_SubmissionResponse;

  @NonNull
  @NotEmpty
  @JsonProperty("NHIF_SubmissionTime")
  private String NHIF_SubmissionTime;

  @NonNull
  @NotEmpty
  @JsonProperty("Control_Number")
  private String Control_Number;

  @NonNull
  @NotEmpty
  @JsonProperty("Identification_Number")
  private String Identification_Number;

  @NonNull
  @NotEmpty
  @JsonProperty("Amount")
  private String Amount;

  @NonNull
  @NotEmpty
  @ValidateStatus
  @JsonProperty("status")
  private String status;

}
