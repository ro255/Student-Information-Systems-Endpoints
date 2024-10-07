package com.example.spring_demo.Dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class AccommodationRequestDto {

  private String residential;
  private String accommodation_status;

  public Object getAccommodationStatus() {
    return accommodation_status;
  }
}
