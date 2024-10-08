package com.example.spring_demo.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import java.util.List;

@Entity(name = "course_registration")
@Table
@Getter
@Setter
@RequiredArgsConstructor
//@SQLDelete(sql = "UPDATE course_registration SET deleted = true WHERE id = ?")
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

  @ManyToMany(mappedBy = "courseRegistrations", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  private List<StudentsDetails> studentsDetails;

  @OneToOne
  @JoinColumn(name = "ca_id")
  private CaResult caResult;


}
