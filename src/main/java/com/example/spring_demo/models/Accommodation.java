package com.example.spring_demo.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Accommodation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long accommodationId;

  private String residential;
  private String accommodation_status;

  @ManyToMany
  @JoinTable (
    name = "accommodation_studentsDetails",
    joinColumns = @JoinColumn(name="accommodationId",referencedColumnName = "accommodationId"),
    inverseJoinColumns = @JoinColumn(name = "StuDetailId")
  )
    private List<StudentsDetails> studentsDetails;



}
