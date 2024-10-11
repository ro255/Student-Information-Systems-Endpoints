package com.example.spring_demo.models;
import com.example.spring_demo.validation.ValidateRemark;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "ca_results")
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
//@SQLDelete(sql = "UPDATE ca_results SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
//@Where(clause = "deleted = false")

public class CaResult {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ca_id;

  @Column(nullable = false)
  private String points;

  @Column(nullable = false)
  @ValidateRemark(message = "Enter a valid remark:")
  private String remark;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "student_detail_id",referencedColumnName = "student_detail_id")
  private StudentsDetails studentsDetails;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "course_id",referencedColumnName = "course_id")
  private CourseRegistration courseRegistration;

}
