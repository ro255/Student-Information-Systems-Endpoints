package com.example.spring_demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity(name = "invoice_list")
@Table
@Getter
@Setter
@NoArgsConstructor
//@SQLDelete(sql = "UPDATE invoice_list SET deleted = true WHERE id = ?")
//@Where(clause = "deleted = false")

public class InvoiceList {

  @Id
  @GeneratedValue
  private Long invoiceListId;

  @OneToOne
  @JoinColumn(name = "invoiceId")
  private CreateInvoice createInvoice;


}
