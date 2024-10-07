package com.example.spring_demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.math.BigInteger;

@Entity(name = "my_full_profile")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@SQLDelete(sql = "UPDATE my_full_profile SET deleted = true WHERE id = ?")
//@Where(clause = "deleted = false")

public class MyFullProfile {

  @Id
  @GeneratedValue
  private BigInteger profileId;

  @OneToOne
  @JoinColumn(name = "student_detail_id")
  private StudentsDetails studentsDetails;

}
