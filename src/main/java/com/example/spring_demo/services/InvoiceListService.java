package com.example.spring_demo.services;

import com.example.spring_demo.auth.AuthenticationResponse;
import com.example.spring_demo.conntroller.InvoiceListRequest;
import com.example.spring_demo.respositories.InvoiceListRepository;
import com.fasterxml.jackson.core.JsonFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;

@Service
@RequiredArgsConstructor


public class InvoiceListService {

//  private final InvoiceListRepository invoiceListRepository;
//  private final JwtServices jwtServices;
//  private final AuthenticationManager authenticationManager;
//
//  public AuthenticationResponse viewInvoiceList(InvoiceListRequest request) {
//    var invoice_list = JsonFactory.builder()
//      .pick(request.getPick())
//      .status(request.getStatus())
//      .build();
//
//
//    invoiceListRepository.save(invoice_list);
//    var jwtToken=jwtServices.generateToken(invoice_list);
//    return AuthenticationResponse.builder()
//      .token(jwtToken)
//      .build();
//
//    return AuthenticationResponse.builder()
//      .token(jwtToken)
//      .build();
//
//  }

}
