package com.example.spring_demo.conntroller;

import com.example.spring_demo.Dto.CreateInvoiceDto;
import com.example.spring_demo.models.CreateInvoice;
import com.example.spring_demo.services.CreateInvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class CreateInvoiceController {

  @Autowired
  private final CreateInvoiceService createInvoiceService;

  @PostMapping("/create_invoice/{student_detail_id}")
  public ResponseEntity<CreateInvoice>  createInvoices(@PathVariable Long student_detail_id , @RequestBody CreateInvoiceDto createInvoiceDto){
    System.out.println(createInvoiceDto);
    System.out.println("==========================");

    CreateInvoice createInvoice= createInvoiceService.createInvoices(student_detail_id,createInvoiceDto);
    return ResponseEntity.ok(createInvoice);

  }

  @GetMapping("/see_invoice")
  public ResponseEntity<List<CreateInvoice>> getInvoice(){
   List<CreateInvoice> createInvoices= createInvoiceService.getInvoice();
   return ResponseEntity.ok(createInvoices);

  }

  @PutMapping("/create_invoice/{invoiceId}")
  public ResponseEntity<CreateInvoice> updateInvoice(@PathVariable Long invoiceId, @RequestBody CreateInvoiceDto createInvoiceDto){
   CreateInvoice createInvoice= createInvoiceService.updateInvoice(invoiceId, createInvoiceDto);
   return ResponseEntity.ok(createInvoice);
  }

  @DeleteMapping("/create_invoice/{invoiceId}")
  public ResponseEntity<Void> deleteInvoice(@PathVariable Long invoiceId){
    createInvoiceService.deleteInvoice(invoiceId);
    return ResponseEntity.ok().build();

  }

}
