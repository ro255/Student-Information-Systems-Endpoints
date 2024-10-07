package com.example.spring_demo.services;

import com.example.spring_demo.Dto.CreateInvoiceDto;
import com.example.spring_demo.models.CreateInvoice;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional

public interface CreateInvoiceService {

  CreateInvoice createInvoive(CreateInvoiceDto createInvoiceDto);

  List<CreateInvoice> getInvoice();

  CreateInvoice updateInvoice(Long invoiceId, CreateInvoiceDto createInvoiceDto);

  void deleteInvoice(Long invoiceId);

}
