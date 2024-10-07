package com.example.spring_demo.conntroller;

import com.example.spring_demo.respositories.InvoiceListRepository;
import com.example.spring_demo.services.InvoiceListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class InvoiceListController {

  private final InvoiceListRepository  invoiceListRepository;
  private final InvoiceListService invoiceListService;

}
