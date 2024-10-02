package com.example.spring_demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;


@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class NhifApplication {

  @Id
  @GeneratedValue
  private Long cardId;

  private Date AYear;

  @Column(unique = true)
  private String RegistrationNo;

  @Column(nullable = false)
  private String Gender;

  @Column(nullable = false)
  private String FormIV_index;

  private String CardNumber;
  private String Category;
  private String Year;
  private String phone;
  private String NHIF_SubmissionResponse;
  private String NHIF_SubmissionTime;
  private String Control_Number;
  private String Identification_Number;
  private String Amount;
  private String status;


  @OneToOne
  @JoinColumn(name = "userId")
  private Users users;


}
