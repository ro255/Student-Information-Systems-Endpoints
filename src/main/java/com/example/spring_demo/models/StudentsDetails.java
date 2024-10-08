package com.example.spring_demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "student_details")
@Table
//@SQLDelete(sql = "UPDATE student_details SET deleted = true WHERE id = ?")
//@Where(clause = "deleted = false")

public class StudentsDetails{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long student_detail_id;

  @Column(name = "registration_number", nullable = false, unique = true)
  private String RegistrationNumber;

  @Column(name = "programme", nullable = false)
  private String Programme;

  @Column(name = "mobile_number", nullable = false)
  private String  MobileNo;

  @Column(name = "gender", nullable = false)
  private String Gender;

  @Column(name = "nationality", nullable = false)
  private String Nationality;

  @Column(name="date_of_birth", nullable = false)
  private LocalDate DateOfBirth;

  @Column(name = "profile", nullable = false)
  private String profile;

  @Column(name = "disability", nullable = false)
  private String Disability;

  @Column(name="year_of_study", nullable = false)
  private String YearOfStudy;

  @Column(name = "form_iv_index", nullable = false)
  private String FormIVIndex;

  @OneToOne
  @JoinColumn(name = "userId")
  private Users userId;

  @OneToMany(mappedBy = "studentsDetails",cascade = CascadeType.ALL)
   private List<Accommodation> accommodation;

  @OneToMany(mappedBy = "studentsDetails",cascade = CascadeType.ALL)
  private List<CreateInvoice> createInvoices;

  @ManyToMany
  @JoinTable(
    name = "studentDetails_nhifApplication",
    joinColumns = @JoinColumn(name = "student_detail_id"),
    inverseJoinColumns = @JoinColumn(name = "cardId")
  )
  private List<NhifApplication> nhifApplications;

  @ManyToMany
  @JoinTable(
    name = "studentDetails_courseRegistration",
    joinColumns = @JoinColumn(name = "student_detail_id"),
    inverseJoinColumns = @JoinColumn(name = "course_id")
  )
  private  List<CourseRegistration> courseRegistrations;

  @OneToMany(mappedBy = "studentsDetails", cascade = CascadeType.ALL)
  private List<IptApplication> iptApplication;

  @OneToOne
  @JoinColumn(name = "result_id")
  private FinalResult finalResult;

  @OneToOne
  @JoinColumn(name = "ca_id")
  private CaResult caResult;

}
