package com.example.spring_demo.services;

import com.example.spring_demo.models.InvoiceList;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional

public interface InvoiceListService {
    List<InvoiceList> getInvoiceList();

}
