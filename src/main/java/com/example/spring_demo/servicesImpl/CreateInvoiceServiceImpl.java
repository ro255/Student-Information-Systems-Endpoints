package com.example.spring_demo.servicesImpl;

import com.example.spring_demo.Dto.CreateInvoiceDto;
import com.example.spring_demo.models.CreateInvoice;
import com.example.spring_demo.respositories.CreateInvoiceRepository;
import com.example.spring_demo.services.CreateInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class CreateInvoiceServiceImpl implements CreateInvoiceService {

  @Autowired
  private final CreateInvoiceRepository createInvoiceRepository;

  public CreateInvoiceServiceImpl(CreateInvoiceRepository createInvoiceRepository) {
    this.createInvoiceRepository = createInvoiceRepository;

  }

  @Override
  public CreateInvoice createInvoive(CreateInvoiceDto createInvoiceDto) {
    CreateInvoice createInvoices = new CreateInvoice();
    createInvoices.setCategory(createInvoiceDto.getCategory());
    createInvoices.setStatus(createInvoiceDto.getStatus());
    createInvoices.setCurrency(createInvoiceDto.getCurrency());
    createInvoices.setInvoice_number(createInvoiceDto.getInvoice_number());
    return createInvoiceRepository.save(createInvoices);

  }

  @Override
  public List<CreateInvoice> getInvoice() {
    return createInvoiceRepository.findAll();
  }

  @Override
  public CreateInvoice updateInvoice(Long invoiceId, CreateInvoiceDto createInvoiceDto) {
    CreateInvoice createInvoices = createInvoiceRepository.findById(invoiceId).orElse(null);
    if(createInvoices != null){
      createInvoices.setCategory(createInvoiceDto.getCategory());
      createInvoices.setStatus(createInvoiceDto.getStatus());
      createInvoices.setCurrency(createInvoiceDto.getCurrency());
      createInvoices.setInvoice_number(createInvoiceDto.getInvoice_number());
      return createInvoiceRepository.save(createInvoices);
    } else {
      return null;
    }

  }

  @Override
  public void deleteInvoice(Long invoiceId) {
    createInvoiceRepository.deleteById(invoiceId);


  }
}
