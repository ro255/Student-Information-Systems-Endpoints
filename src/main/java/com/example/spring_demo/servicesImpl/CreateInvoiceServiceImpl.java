package com.example.spring_demo.servicesImpl;

import com.example.spring_demo.Dto.CreateInvoiceDto;
import com.example.spring_demo.models.CreateInvoice;
import com.example.spring_demo.models.StudentsDetails;
import com.example.spring_demo.respositories.CreateInvoiceRepository;
import com.example.spring_demo.respositories.StudentDetailsRepository;
import com.example.spring_demo.services.CreateInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CreateInvoiceServiceImpl implements CreateInvoiceService {

  @Autowired
  private final CreateInvoiceRepository createInvoiceRepository;
  @Autowired
  private final StudentDetailsRepository studentDetailsRepository;

  public CreateInvoiceServiceImpl(CreateInvoiceRepository createInvoiceRepository, StudentDetailsRepository studentDetailsRepository) {
    this.createInvoiceRepository = createInvoiceRepository;
    this.studentDetailsRepository = studentDetailsRepository;
  }

  @Override
  public CreateInvoice createInvoices(Long student_detail_id, CreateInvoiceDto createInvoiceDto) {

    StudentsDetails student = studentDetailsRepository.findById(student_detail_id)
      .orElseThrow(() -> new RuntimeException("Student not found"));

    CreateInvoice createInvoice = new CreateInvoice();
    createInvoice.setCategory(createInvoiceDto.getCategory());
    createInvoice.setStatus(createInvoiceDto.getStatus());
    createInvoice.setCurrency(createInvoiceDto.getCurrency());
    createInvoice.setInvoice_number(createInvoiceDto.getInvoice_number());

    createInvoice.setStudentsDetails(student);
    return createInvoiceRepository.save(createInvoice);

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
