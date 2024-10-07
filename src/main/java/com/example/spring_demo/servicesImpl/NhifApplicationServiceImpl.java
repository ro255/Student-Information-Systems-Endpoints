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
    System.out.println("===================START===========================");
    System.out.println("===================START===========================");

    NhifApplication nhifApplication = new NhifApplication();
    nhifApplication.setNHIF_SubmissionResponse(nhifApplicationDto.getNHIF_SubmissionResponse());
    System.out.println(nhifApplication.getNHIF_SubmissionResponse());
    nhifApplication.setNHIF_SubmissionTime(nhifApplicationDto.getNHIF_SubmissionTime());
    nhifApplication.setStatus(nhifApplicationDto.getStatus());
    nhifApplication.setAmount(nhifApplicationDto.getAmount());
    nhifApplication.setCardNumber(String.valueOf(nhifApplicationDto.getCardNumber()));
    nhifApplication.setIdentification_Number(String.valueOf(nhifApplicationDto.getIdentification_Number()));
    nhifApplication.setControl_Number(String.valueOf(nhifApplicationDto.getControl_Number()));
    nhifApplication.setCategory(String.valueOf(nhifApplicationDto.getCategory()));

    System.out.println("====================END==============================");

    nhifApplicationRepository.save(nhifApplication);
    return nhifApplication;

  }

  @Override
  public List<NhifApplication> getAllApplicants() {
    return nhifApplicationRepository.findAll();

  }

  @Override
  public void DeleteNhifCard(Long cardId) {
    nhifApplicationRepository.deleteById(cardId);

  }

  @Override
  public NhifApplication UpdateNhifCard(Long cardId, NhifApplicationDto nhifApplicationDto) {
    if(cardId == null) {
      return null;
    }
    NhifApplication nhifApplication = nhifApplicationRepository.findById(cardId).orElse(null);
    if (nhifApplication != null) {
      nhifApplication.setCardNumber(nhifApplicationDto.getCardNumber());
      nhifApplication.setIdentification_Number(nhifApplicationDto.getIdentification_Number());
      nhifApplication.setControl_Number(nhifApplicationDto.getControl_Number());
      nhifApplication.setCategory(nhifApplicationDto.getCategory());
      nhifApplication.setAmount(nhifApplicationDto.getAmount());
      nhifApplication.setNHIF_SubmissionResponse(nhifApplicationDto.getNHIF_SubmissionResponse());
      nhifApplication.setStatus(nhifApplicationDto.getStatus());
      nhifApplication.setNHIF_SubmissionTime(nhifApplicationDto.getNHIF_SubmissionTime());
      nhifApplication.setStatus(nhifApplicationDto.getStatus());

      nhifApplicationRepository.save(nhifApplication);
      return nhifApplication;

    } else{

      return null;

    }

  }

}
