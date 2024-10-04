package com.example.spring_demo.conntroller;


import com.example.spring_demo.auth.AuthenticationResponse;
import com.example.spring_demo.models.InvoiceList;
import com.example.spring_demo.responses.ApiResponse;
import com.example.spring_demo.respositories.InvoiceListRepository;
import com.example.spring_demo.services.InvoiceListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor

public class InvoiceListController {

  private final InvoiceListRepository  invoiceListRepository;
  private final InvoiceListService invoiceListService;


//  @GetMapping("/see_invoice")
//  public ResponseEntity<List<InvoiceList>> viewInvoiceList() {
//    try {
//       List<InvoiceList> invoiceLists = invoiceListRepository.findAll();
//      ApiResponse<AuthenticationResponse> apiResponse= new ApiResponse<>(
//        HttpStatus.OK.value(),
//        "The invoice list is available ",
//        null
//      );
//
//      return ResponseEntity.ok(invoiceLists);
//    } catch (Exception e) {
//      ApiResponse<AuthenticationResponse> apiResponse= new ApiResponse<>(
//        HttpStatus.BAD_REQUEST.value(),
//        "There is no any invoice available:",
//        null
//      );
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((List<InvoiceList>) apiResponse.getData());
//
//    }
//
//
//  }
}
