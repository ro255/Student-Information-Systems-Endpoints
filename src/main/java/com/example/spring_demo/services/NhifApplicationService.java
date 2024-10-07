package com.example.spring_demo.services;

import com.example.spring_demo.Dto.NhifApplicationDto;
import com.example.spring_demo.models.NhifApplication;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional

public interface NhifApplicationService {

  NhifApplication nhifApplications(NhifApplicationDto nhifApplicationDto);

  List<NhifApplication> getAllApplicants();

  NhifApplication UpdateNhifCard(Long cardId, NhifApplicationDto nhifApplicationDto);

  void DeleteNhifCard(Long cardId);

}
