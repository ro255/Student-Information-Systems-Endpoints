package com.example.spring_demo.Dto;

import com.example.spring_demo.validation.ValidateRegion;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class IptApplicationDto {

  @ValidateRegion
  private String region;
  @NonNull
  @NotEmpty
  private String institution;
  @NonNull
  @NotEmpty
  private String section;
  @NonNull
  @NotEmpty
  private String appliedDate;

}
