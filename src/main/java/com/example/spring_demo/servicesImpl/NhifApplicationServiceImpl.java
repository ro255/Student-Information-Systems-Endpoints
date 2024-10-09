package com.example.spring_demo.servicesImpl;

import com.example.spring_demo.Dto.NhifApplicationDto;
import com.example.spring_demo.models.NhifApplication;
import com.example.spring_demo.respositories.NhifApplicationRepository;
import com.example.spring_demo.services.NhifApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NhifApplicationServiceImpl implements NhifApplicationService {

  @Autowired
  private final NhifApplicationRepository nhifApplicationRepository;

  public NhifApplicationServiceImpl(NhifApplicationRepository nhifApplicationRepository) {
    this.nhifApplicationRepository = nhifApplicationRepository;

  }

  @Override
  public NhifApplication nhifApplications(NhifApplicationDto nhifApplicationDto) {
    System.out.println(nhifApplicationDto);
    System.out.println("===================START===========================");

    NhifApplication nhif_application = new NhifApplication();
    nhif_application.setNHIF_SubmissionResponse(nhifApplicationDto.getNHIF_SubmissionResponse());
    nhif_application.setNHIF_SubmissionTime(nhifApplicationDto.getNHIF_SubmissionTime());
    nhif_application.setStatus(nhifApplicationDto.getStatus());
    nhif_application.setAmount(nhifApplicationDto.getAmount());
    nhif_application.setCardNumber(String.valueOf(nhifApplicationDto.getCardNumber()));
    nhif_application.setIdentification_Number(String.valueOf(nhifApplicationDto.getIdentification_Number()));
    nhif_application.setControl_Number(String.valueOf(nhifApplicationDto.getControl_Number()));
    nhif_application.setCategory(String.valueOf(nhifApplicationDto.getCategory()));

    System.out.println(nhifApplicationDto.getCategory());


    System.out.println("====================END==============================");
    nhifApplicationRepository.save(nhif_application);
    return nhif_application;

  }

  @Override
  public List<NhifApplication> getAllApplicants() {
    return nhifApplicationRepository.findAll();

  }

  @Override
  public void DeleteNhifCard(Long cardId) {
    if (nhifApplicationRepository.existsById(cardId)) {
      nhifApplicationRepository.deleteById(cardId);
    } else {
      return ;
    }

  }

  @Override
  public NhifApplication UpdateNhifCard(Long cardId, NhifApplicationDto nhifApplicationDto) {
    NhifApplication nhif_application = nhifApplicationRepository.findById(cardId).orElse(null);

    System.out.println(nhifApplicationDto);
    System.out.println("==============================START==============================");

    if (nhifApplicationDto != null) {
      nhif_application.setCardNumber(nhifApplicationDto.getCardNumber());
      nhif_application.setIdentification_Number(nhifApplicationDto.getIdentification_Number());
      nhif_application.setControl_Number(nhifApplicationDto.getControl_Number());
      nhif_application.setCategory(nhifApplicationDto.getCategory());
      nhif_application.setAmount(nhifApplicationDto.getAmount());
      nhif_application.setNHIF_SubmissionResponse(nhifApplicationDto.getNHIF_SubmissionResponse());
      nhif_application.setStatus(nhifApplicationDto.getStatus());
      nhif_application.setNHIF_SubmissionTime(nhifApplicationDto.getNHIF_SubmissionTime());
      nhif_application.setStatus(nhifApplicationDto.getStatus());

     System.out.println(nhif_application);
     System.out.println("====================END============================");

      nhifApplicationRepository.save(nhif_application);
      return nhif_application;

    } else{

      return null;

    }

  }

}
