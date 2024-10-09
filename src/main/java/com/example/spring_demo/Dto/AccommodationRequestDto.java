package com.example.spring_demo.Dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class AccommodationRequestDto {

  @NonNull
  @NotEmpty
  private String residential;

  @NonNull
  @NotEmpty
  private String accommodation_status;

  public Object getAccommodationStatus() {
    return accommodation_status;
  }
}
