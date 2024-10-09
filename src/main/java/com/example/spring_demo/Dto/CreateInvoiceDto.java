package com.example.spring_demo.Dto;

import com.example.spring_demo.validation.ValidateCategory;
import com.example.spring_demo.validation.ValidateStatus;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class CreateInvoiceDto {

  @NonNull
  @NotEmpty
  private String invoice_number;
  @NonNull
  @NotEmpty
  @ValidateCategory
  private String category;
  @NonNull
  @NotEmpty
  private String currency;
  @NonNull
  @NotEmpty
  @ValidateStatus
  private String status;

}
