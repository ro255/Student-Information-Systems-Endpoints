package com.example.spring_demo.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;


@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor


public class IptApplication {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long applicationId;

  private String region;
  private String institution;
  private String section;
  private Date appliedDate;

}
