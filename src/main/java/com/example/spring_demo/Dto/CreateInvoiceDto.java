package com.example.spring_demo.Dto;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class CreateInvoiceDto {

  private String invoice_number;
  private String category;
  private String currency;
  private String status;


}
