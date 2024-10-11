package com.example.spring_demo.conntroller;

import com.example.spring_demo.models.InvoiceList;
import com.example.spring_demo.services.InvoiceListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class InvoiceListController {
  @Autowired
  private final InvoiceListService invoiceListService;

  @GetMapping("/invoice_list")
  public ResponseEntity<List<InvoiceList>> getInvoiceList(){
    List<InvoiceList> invoiceLists= invoiceListService.getInvoiceList();
    return ResponseEntity.ok(invoiceLists);
  }

}
