package com.example.spring_demo.Dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CourseRegistrationDto {

  @NonNull
  @NotEmpty
  private String course_code;

  @NonNull
  @NotEmpty
  private String course_name;

  @NonNull
  @NotEmpty
  private Integer unit;
  @NonNull
  @NotEmpty
  private  String status;

}
