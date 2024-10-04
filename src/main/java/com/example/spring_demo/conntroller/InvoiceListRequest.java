package com.example.spring_demo.conntroller;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class InvoiceListRequest {

  private String pick;
  private String status;
}
