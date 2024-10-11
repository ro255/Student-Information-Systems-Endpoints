package com.example.spring_demo.models;

import com.example.spring_demo.validation.ValidateCategory;
import com.example.spring_demo.validation.ValidateStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "create_invoice")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@SQLDelete(sql = "UPDATE create_invoice SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
//@Where(clause = "deleted = false")

public class CreateInvoice {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long invoiceId;

  @Column(name = "invoice_number")
  private String invoice_number;

  @ValidateCategory(message ="Enter a valid category: It should be either NHIF,Tuition Fee,Accommodation or Direct Costs")
  @Column(name = "category")
  private String category;

  @Column(name = "currency")
  private String currency;

  @ValidateStatus(message = "Enter a valid status:")
  @Column(name = "status")
  private String status;

  @ManyToOne
  @JoinColumn(name = "student_detail_id",referencedColumnName = "student_detail_id")
  private StudentsDetails studentsDetails;

  @OneToOne(mappedBy = "createInvoice",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
  private InvoiceList invoiceList;

}
