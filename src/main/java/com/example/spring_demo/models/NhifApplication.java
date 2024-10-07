package com.example.spring_demo.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "nhif_application")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@SQLDelete(sql = "UPDATE nhif_application SET deleted = true WHERE id = ?")
//@Where(clause = "deleted = false")

public class NhifApplication {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
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

  @Column(name = "status",nullable = false)
  private String status;

  @OneToOne
  @JoinColumn(name = "userId")
  private Users userId;

  @OneToOne
  @JoinColumn(name = "student_detail_id")
  private StudentsDetails studentsDetails;


}
