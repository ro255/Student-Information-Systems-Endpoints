package com.example.spring_demo.servicesImpl;

import com.example.spring_demo.models.InvoiceList;
import com.example.spring_demo.respositories.InvoiceListRepository;
import com.example.spring_demo.services.InvoiceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InvoiceListServiceImpl implements InvoiceListService {

  @Autowired
  private final InvoiceListRepository invoiceListRepository;

  public InvoiceListServiceImpl(InvoiceListRepository invoiceListRepository) {
    this.invoiceListRepository = invoiceListRepository;
  }

  @Override
  public List<InvoiceList> getInvoiceList() {
    return invoiceListRepository.findAll();
  }

}
