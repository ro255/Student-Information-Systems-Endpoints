package com.example.spring_demo.Dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class FinalResultDto {

  @NonNull
  @NotEmpty
  private  String course_code;
  @NonNull
  @NotEmpty
  private  String course_name;
  @NonNull
  @NotEmpty
  private  String unit;
  @NonNull
  @NotEmpty
  private  String grade;
  @NonNull
  @NotEmpty
  private String points;
  @NonNull
  @NotEmpty
  private String remark;

}
