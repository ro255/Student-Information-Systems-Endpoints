package com.example.spring_demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class InvoiceList {

  @Id
  @GeneratedValue
  private Long invoiceListId;




//  @ManyToMany
//  @JoinTable(
//    name = "Invoice_list",
//    joinColumns = @JoinColumn(name = "invoiceListId"),
//    inverseJoinColumns = @JoinColumn(name= "invoiceId")
//  )
//  private List<InvoiceList> invoiceList;


  @OneToOne
  @JoinColumn(name = "invoiceId")
  private CreateInvoice invoiceId;

}
