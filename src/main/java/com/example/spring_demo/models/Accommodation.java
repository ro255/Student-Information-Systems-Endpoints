package com.example.spring_demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity(name = "accommodation")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@SQLDelete(sql = "UPDATE accommodation SET deleted = true WHERE id = ?")
//@Where(clause = "deleted = false")

public class Accommodation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long accommodationId;

  @Column(name= "residential")
  private String residential;

  @Column(name = "accommodation_status")
  private String accommodation_status;

  @ManyToOne
  @JoinColumn(name = "student_detail_id")
  private StudentsDetails studentsDetails;

  public void setAccommodationStatus(Object accommodationStatus) {
    this.accommodation_status = accommodationStatus.toString();
  }
}
