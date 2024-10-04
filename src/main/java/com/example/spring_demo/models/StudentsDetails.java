package com.example.spring_demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor


public class StudentsDetails {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long StuDetailId;

  private Integer RegistrationNumber;
  private String Programme;
  private String  MobileNo;
  private String Gender;
  private String Nationality;

  @Column(name="date_of_birth")
  private LocalDate DateOfBirth;

  private String profile;
  private String Disability;

  @Column(name="year_of_study")
  private String YearOfStudy;

  @Column(name = "form_iv_index")
  private String FormIVIndex;



  @OneToOne
  @JoinColumn(name = "userId")
  private Users userId;

  @ManyToMany(mappedBy = "studentsDetails")
  private List<Accommodation> accommodations;


}
