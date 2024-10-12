package com.example.spring_demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "accommodation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@SQLDelete(sql = "UPDATE accommodation SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
//@Where(clause = "deleted = false")

public class Accommodation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long accommodationId;

  @Column(name= "residential")
  private String residential;

  @Column(name = "accommodation_status")
  private String accommodation_status;

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "student_detail_id", referencedColumnName = "student_detail_id")
  @JsonBackReference
  private StudentsDetails studentsDetails;


  public void setAccommodationStatus(Object accommodationStatus) {
    this.accommodation_status = accommodationStatus.toString();
  }

}
