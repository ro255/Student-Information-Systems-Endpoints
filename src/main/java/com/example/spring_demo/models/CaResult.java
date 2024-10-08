package com.example.spring_demo.models;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "ca_results")
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class CaResult {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ca_id;

  @Column
  private String points;

  @Column
  private String remark;

  @OneToOne
  @JoinColumn(name = "student_detail_id")
  private StudentsDetails studentsDetails;

  @OneToOne
  @JoinColumn(name = "course_id")
  private CourseRegistration courseRegistration;


}
