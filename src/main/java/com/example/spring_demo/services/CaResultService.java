package com.example.spring_demo.services;

import com.example.spring_demo.Dto.CaResultDto;
import com.example.spring_demo.models.CaResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CaResultService {

  CaResult createCaResult(CaResultDto caResultDto);

  List<CaResult> getCaResults();


  void deleteCaResult(Long caId);

  CaResult updateCaResult(Long caId, CaResultDto caResultDto);

}
