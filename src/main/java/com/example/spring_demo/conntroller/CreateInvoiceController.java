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

  @PostMapping("/create_invoice")
  public ResponseEntity<CreateInvoice>  createInvoive(@RequestBody CreateInvoiceDto createInvoiceDto){
    CreateInvoice createInvoice= createInvoiceService.createInvoive(createInvoiceDto);
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
  public ResponseEntity<CreateInvoice> deleteInvoice(@PathVariable Long invoiceId){
    createInvoiceService.deleteInvoice(invoiceId);
    return ResponseEntity.ok().build();
  }

}
