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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long cardId;

  @Column(name = "card_number",unique = true)
  private String CardNumber;

  @Column(name = "category")
  private String Category;

  @Column(name = "nhif_submissionResponse")
  private String NHIF_SubmissionResponse;

  @Column(name = "nhif_submission_time")
  private String NHIF_SubmissionTime;

  @Column(name = "control_number", unique = true)
  private String Control_Number;

  @Column(name = "identification_number")
  private String Identification_Number;

  @Column(name = "amount")
  private String Amount;

  @Column(name = "status")
  private String status;

  @OneToOne
  @JoinColumn(name = "userId")
  private Users userId;

  @OneToOne
  @JoinColumn(name = "student_detail_id")
  private StudentsDetails studentsDetails;


}
