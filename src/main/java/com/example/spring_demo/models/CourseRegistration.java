package com.example.spring_demo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@RequiredArgsConstructor

public class CourseRegistration {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer serial_number;

  private String course_code;
  private String course_name;
  private Integer unit;
  private  String status;


}
