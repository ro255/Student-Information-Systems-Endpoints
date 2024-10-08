package com.example.spring_demo.Dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class FinalResultDto {

  private  String course_code;
  private  String course_name;
  private  String unit;
  private  String grade;
  private String points;
  private String remark;

}
