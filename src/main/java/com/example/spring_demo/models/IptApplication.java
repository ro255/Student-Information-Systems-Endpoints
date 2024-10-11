package com.example.spring_demo.models;

import com.example.spring_demo.validation.ValidateRegion;
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
//@SQLDelete(sql = "UPDATE ipt_application SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
//@Where(clause = "deleted = false")

public class IptApplication{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ipt_application_id;

  @Column(name = "applied_date")
  private String appliedDate;

  @ValidateRegion(message = "Enter a valid region")
  @Column(name = "region")
  private String region;

  @Column(name = "institution")
  private String institution;

  @Column(name = "section")
  private String section;

  @ManyToOne
  @JoinColumn(name = "student_detail_id",referencedColumnName = "student_detail_id")
  private StudentsDetails studentsDetails;

}
