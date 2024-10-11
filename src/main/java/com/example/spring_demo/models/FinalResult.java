package com.example.spring_demo.models;

import com.example.spring_demo.validation.ValidateGrade;
import com.example.spring_demo.validation.ValidateRemark;
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
//@SQLDelete(sql = "UPDATE final_results SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
//@Where(clause = "deleted = false")

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

  @ValidateGrade(message = "Enter a valid grade: It should be either A,B,C or SUPP")
  private String grade;

  @Column(name = "points", nullable = false)
  private String points;

  @ValidateRemark(message = "Enter a valid remark:")
  private String remark;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "student_detail_id",referencedColumnName = "student_detail_id")
  private StudentsDetails studentsDetails;

}
