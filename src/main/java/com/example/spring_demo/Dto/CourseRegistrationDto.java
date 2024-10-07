package com.example.spring_demo.Dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CourseRegistrationDto {

  private String course_code;
  private String course_name;
  private Integer unit;
  private  String status;

}
