package com.example.spring_demo.Dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class CaResultDto {

  @NonNull
  @NotEmpty
  private String points;

  @NonNull
  @NotEmpty
  private String remark;

}
