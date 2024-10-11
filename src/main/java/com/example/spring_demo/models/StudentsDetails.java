package com.example.spring_demo.models;

import com.example.spring_demo.validation.ValidateGender;
import com.example.spring_demo.validation.ValidateProgramme;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student_details")
//@SQLDelete(sql = "UPDATE student_details SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
//@Where(clause = "deleted = false")

public class StudentsDetails{

  @Id
  @Column(name = "student_detail_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long student_detail_id;

  @Column(name = "registration_number", nullable = false, unique = true)
  private String RegistrationNumber;

  @Column(name = "programme", nullable = false)
  @ValidateProgramme(message = "Enter a valid programme name:")
  private String Programme;

  @Pattern(regexp = "(^(([2]{1}[5]{2})|([0]{1}))[1-9]{2}[0-9]{7}$)", message = "Please enter valid phone number eg. 255766040293")
  @Column(name = "mobile_number", nullable = false)
  private String  MobileNo;

  @ValidateGender(message = "Invalid gender: It should be either Male or Female")
  private String Gender;

  @Column(name = "nationality", nullable = false)
  private String Nationality;

  @Column(name="date_of_birth", nullable = false)
  private String DateOfBirth;

  @Column(name = "profile", nullable = false)
  private String profile;

  @Column(name = "disability", nullable = false)
  private String Disability;

  @Column(name="year_of_study", nullable = false)
  private String YearOfStudy;

  @Column(name = "form_iv_index", nullable = false)
  private String FormIVIndex;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
  private Users users;

  @OneToMany(mappedBy = "studentsDetails",cascade = CascadeType.ALL)
  @JsonManagedReference
   private List<Accommodation> accommodation;

  @OneToMany(mappedBy = "studentsDetails",cascade = CascadeType.ALL)
  private List<CreateInvoice> createInvoices;

  @OneToOne(mappedBy = "studentsDetails",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
  private NhifApplication nhifApplication;

  @ManyToMany(cascade = {CascadeType.ALL})
  @JoinTable(
    name = "studentDetails_courseRegistration",
    joinColumns = @JoinColumn(name = "student_detail_id"),
    inverseJoinColumns = @JoinColumn(name = "course_id")
  )
  private  List<CourseRegistration> courseRegistrations;

  @OneToMany(mappedBy = "studentsDetails", cascade = CascadeType.ALL)
  private List<IptApplication> iptApplication;

  @OneToOne(mappedBy = "studentsDetails")
  private FinalResult finalResult;

  @OneToOne(mappedBy = "studentsDetails")
  private CaResult caResult;

  public Long setUserId(Long userId) {
    return userId;

  }

}
