package com.example.spring_demo.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class NhifApplication {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long cardId;

  private String CardNumber;
  private String Category;
  private String NHIF_SubmissionResponse;
  private String NHIF_SubmissionTime;
  private String Control_Number;
  private String Identification_Number;
  private String Amount;
  private String status;

  private Integer StuDetailId;


  @OneToOne
  @JoinColumn(name = "userId")
  private Users userId;




}
