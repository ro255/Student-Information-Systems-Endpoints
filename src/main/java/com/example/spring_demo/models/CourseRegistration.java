package com.example.spring_demo.models;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "course_registration")
@Getter
@Setter
@RequiredArgsConstructor
//@SQLDelete(sql = "UPDATE course_registration SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
//@Where(clause = "deleted = false")

public class CourseRegistration {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long course_id;

  @Column(name = "course_code")
  private String course_code;

  @Column(name = "course_name")
  private String course_name;

  @Column(name = "unit")
  private Integer unit;

  @Column(name = "status")
  private  String status;

  @ManyToMany(mappedBy = "courseRegistrations")
  private List<StudentsDetails> studentsDetails;

  @OneToOne(mappedBy = "courseRegistration",fetch = FetchType.LAZY)
  private CaResult ca_id;

 }
