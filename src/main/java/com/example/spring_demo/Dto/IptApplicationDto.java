package com.example.spring_demo.Dto;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class IptApplicationDto {

  private String region;
  private String institution;
  private String section;
  private String appliedDate;

}
