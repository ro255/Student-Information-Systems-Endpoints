package com.example.spring_demo.models;

import com.example.spring_demo.validation.ValidateStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "nhif_application")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@SQLDelete(sql = "UPDATE nhif_application SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
//@Where(clause = "deleted = false")

public class NhifApplication {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long cardId;

  @Column(name = "card_number",unique = true, nullable = false)
  private String CardNumber;

  @Column(name = "category",nullable = false)
  private String Category;

  @Column(name = "nhif_submissionResponse",nullable = false)
  private String NHIF_SubmissionResponse;

  @Column(name = "nhif_submission_time",nullable = false)
  private String NHIF_SubmissionTime;

  @Column(name = "control_number", unique = true,nullable = false)
  private String Control_Number;

  @Column(name = "identification_number",nullable = false)
  private String Identification_Number;

  @Column(name = "amount",nullable = false)
  private String Amount;

  @ValidateStatus(message = "Enter a valid status: It should be either Paid,Pending or Not Paid")
  private String status;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "student_detail_id",referencedColumnName = "student_detail_id")
  private StudentsDetails studentsDetails;

}
