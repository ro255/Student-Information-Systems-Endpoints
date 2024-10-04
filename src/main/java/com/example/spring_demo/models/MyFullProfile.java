package com.example.spring_demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigInteger;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MyFullProfile {

  @Id
  @GeneratedValue
  private BigInteger profileId;

  @ManyToOne
  @JoinColumn(name = "StuDetailId")
  private StudentsDetails StuDetailId;


}
