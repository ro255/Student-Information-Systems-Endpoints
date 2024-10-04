package com.example.spring_demo.conntroller;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateInvoiceRequest {

  private String invoiceNumber;
  private String category;
  private String currency;
  private String status;

}
