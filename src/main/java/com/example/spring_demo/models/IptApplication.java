package com.example.spring_demo.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "ipt_application")
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
//@SQLDelete(sql = "UPDATE ipt_application SET deleted = true WHERE id = ?")
//@Where(clause = "deleted = false")

public class IptApplication{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ipt_application_id;

  @Column(name = "applied_date")
  private String appliedDate;

  @Column(name = "region")
  private String region;

  @Column(name = "institution")
  private String institution;

  @Column(name = "section")
  private String section;

  @ManyToOne
  @JoinColumn(name = "student_detail_id")
  private StudentsDetails studentsDetails;


}
