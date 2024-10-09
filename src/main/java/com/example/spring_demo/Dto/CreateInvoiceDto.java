package com.example.spring_demo.Dto;

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
  private String category;
  @NonNull
  @NotEmpty
  private String currency;
  @NonNull
  @NotEmpty
  private String status;

}
