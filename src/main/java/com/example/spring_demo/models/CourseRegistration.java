package com.example.spring_demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@RequiredArgsConstructor

public class CourseRegistration {

  @Id
  @GeneratedValue
  private Integer serial_number;

  private String course_code;
  private String course_name;
  private Integer unit;
  private  String status;


}
