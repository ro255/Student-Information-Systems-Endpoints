package com.example.spring_demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "final_results")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class FinalResult {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long result_id;

  @Column(name = "course_code",nullable = false)
  private String course_code;

  @Column(name = "course_name", nullable = false)
  private String course_name;

  @Column(name = "unit", nullable = false)
  private  String unit;

  @Column(name = "grade", nullable = false)
  private String grade;

  @Column(name = "points", nullable = false)
  private String points;

  @Column(name = "remark",nullable = false)
  private String remark;

  @OneToOne
  @JoinColumn(name = "student_detail_id")
  private StudentsDetails studentsDetails;

}
