package com.example.spring_demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "invoice_list")
@Getter
@Setter
@NoArgsConstructor
//@SQLDelete(sql = "UPDATE invoice_list SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
//@Where(clause = "deleted = false")

public class InvoiceList {

  @Id
  @GeneratedValue
  private Long invoiceListId;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "invoiceId")
  private CreateInvoice createInvoice;

}
