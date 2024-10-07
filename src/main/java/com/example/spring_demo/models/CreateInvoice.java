package com.example.spring_demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity(name = "create_invoice")
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@SQLDelete(sql = "UPDATE create_invoice SET deleted = true WHERE id = ?")
//@Where(clause = "deleted = false")

public class CreateInvoice {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long invoiceId;

  @Column(name = "invoice_number")
  private String invoice_number;

  @Column(name = "category")
  private String category;

  @Column(name = "currency")
  private String currency;

  @Column(name = "status")
  private String status;

  @ManyToOne
  @JoinColumn(name = "student_detail_id")
  private StudentsDetails studentsDetails;

  @OneToOne
  @JoinColumn(name = "invoiceListId")
  private InvoiceList invoiceList;



}
